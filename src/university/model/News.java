
import java.io.*;
import java.util.*;

/**
 * 
 */
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    public News() {
    }

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Topic topic;

    /**
     * 
     */
    private boolean isPinned;

    /**
     * 
     */
    private Date date;


}