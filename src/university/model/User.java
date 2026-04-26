
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public User() {
    }

    /**
     * 
     */
    protected String {length userID = 16};

    /**
     * 
     */
    protected String login;

    /**
     * 
     */
    protected String password;

    /**
     * 
     */
    protected String name;

    /**
     * 
     */
    protected langue lan;


    /**
     * @param String l 
     * @param String p 
     * @return
     */
    public boolean login(void String l, void String p) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public void viewNews() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void readPapers() {
        // TODO implement here
        return null;
    }

    /**
     * @param String desc 
     * @return
     */
    public void submitTechRequest(void String desc) {
        // TODO implement here
        return null;
    }

    /**
     * @param Journal j 
     * @return
     */
    public void subscribeToJournal(void Journal j) {
        // TODO implement here
        return null;
    }

}