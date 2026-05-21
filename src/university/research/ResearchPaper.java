package university.research;

import university.data.SerializableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearchPaper extends SerializableModel {
    private static final long serialVersionUID = 1L;

    private String title;
    private int views;
    private int citations;
    private Date publishDate;
    private List<ResearcherDecorator> authors = new ArrayList<>(); // Переименовали в авторов
    private List<ResearchPaper> references = new ArrayList<>();

    public ResearchPaper(String id, String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be blank");
        this.id = id; // Передаем сгенерированный строковый CRS-код или аналогичный
        this.title = title;
        this.views = 0;
        this.citations = 0;
        this.publishDate = new Date();
    }

    public String getTitle() { return title; }
    public int getViews() { return views; }
    public int getCitations() { return citations; }
    public Date getPublishDate() { return publishDate; }
    public List<ResearcherDecorator> getAuthors() { return authors; }
    public List<ResearchPaper> getReferences() { return List.copyOf(references); }

    public void addReference(ResearchPaper reference) {
        if (reference == null) return;
        if (this.equals(reference)) {
            throw new IllegalArgumentException("A paper cannot reference itself.");
        }
        if (!references.contains(reference)) {
            references.add(reference);
        }
    }

    public void addAuthor(ResearcherDecorator author) {
        if (author == null) return;
        if (!authors.contains(author)) {
            authors.add(author);
        }
        if (!author.getPapers().contains(this)) {
            author.addPaper(this);
        }
    }

    public void cite() { this.citations++; }
    public void incrementViews() { this.views++; }

    @Override
    public String asLine() {
        return String.format("Paper ID: %s | Title: %s | Citations: %d | Views: %d",
                id, title, citations, views);
    }

    @Override
    public String asTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paper ID: ").append(id).append('\n');
        sb.append("Title: ").append(title).append('\n');
        sb.append("Published Date: ").append(publishDate).append('\n');
        sb.append("Metrics: ").append(views).append(" views, ").append(citations).append(" citations\n");
        sb.append("Authors:\n");
        for (ResearcherDecorator rd : authors) {
            sb.append("  - ").append(rd.getUser().getLastName()).append("\n");
        }
        return sb.toString();
    }
}