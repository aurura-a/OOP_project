
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Researcher implements CanBeResearcher, Serializable {
    private static final long serialVersionUID = 1L; 

    /**
     * Default constructor
     */
    public Researcher() {
    }

    /**
     * 
     */
    private Set<ResearchPaper> papers;

    /**
     * 
     */
    private Set<ResearchProject> projects;




    /**
     * @return
     */
    public int calculateHIndex() {
        // TODO implement here
        return 0;
    }

    /**
     * @param Comparator c 
     * @return
     */
    public void printPapers(void Comparator c) {
        // TODO implement here
        return null;
    }

    /**
     * @param ResearchPaper p 
     * @return
     */
    public void publishPaper(void ResearchPaper p) {
        // TODO implement here
        return null;
    }

}