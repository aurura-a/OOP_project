package university.research;

import university.data.SerializableModel;
import university.users.User;
import java.util.ArrayList;
import java.util.List;

public class ResearcherDecorator extends SerializableModel {
    private static final long serialVersionUID = 1L;

    private User user; // Обернутый пользователь (Студент или Преподаватель)
    private List<ResearchPaper> papers = new ArrayList<>();

    public ResearcherDecorator(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        this.user = user;
        this.id = "RES-" + user.getId(); // Генерируем исследовательский ID на базе основного
    }

    public User getUser() { return user; }
    public List<ResearchPaper> getPapers() { return List.copyOf(papers); }

    public void addPaper(ResearchPaper paper) {
        if (paper == null) return;
        if (!papers.contains(paper)) {
            this.papers.add(paper);
        }
        // Безопасное двухстороннее связывание без зацикливания
        if (!paper.getAuthors().contains(this)) {
            paper.getAuthors().add(this);
        }
    }

    @Override
    public String asLine() {
        return String.format("Researcher ID: %s | Name: %s %s | Papers: %d",
                id, user.getFirstName(), user.getLastName(), papers.size());
    }

    @Override
    public String asTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("Researcher Profile Details:\n");
        sb.append("Main User ID: ").append(user.getId()).append("\n");
        sb.append("Full Name: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
        sb.append("Total Papers Published: ").append(papers.size()).append("\n");
        sb.append("--- List of Papers ---\n");
        for (ResearchPaper p : papers) {
            sb.append("- ").append(p.getTitle()).append(" (Citations: ").append(p.getCitations()).append(")\n");
        }
        return sb.toString();
    }
}
