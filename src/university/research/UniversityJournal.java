package university.research;

import java.io.Serializable;
import java.util.List;

public class UniversityJournal implements Serializable{
	public String name;
    public List<ResearchPaper> papers;
    private List<User> subscribers;
    public void publishPaper(ResearchPaper paper) {
        papers.add(paper);
        notifySubscribers(paper);
        
    }

}
