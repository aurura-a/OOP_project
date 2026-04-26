
import java.io.*;
import java.util.*;

/**
 * 
 */
public class DatabaseSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    public DatabaseSingleton() {
    }

    /**
     * 
     */
    private void static Database instance;

    /**
     * 
     */
    private Set<Course> allCourses;

    /**
     * 
     */
    private Set<News> news;

    /**
     * 
     */
    public Set<Request> techRequests;

    /**
     * 
     */
    public Map Users;

    
    /**
     * @return
     */
    public Database static getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void saveData() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void loadData() {
        // TODO implement here
        return null;
    }

}