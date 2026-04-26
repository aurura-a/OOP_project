
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Employee extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    public Employee() {
    }

    /**
     * 
     */
    protected salary double;

    /**
     * 
     */
    public Set<Message> inbox;


    /**
     * @param Employee to 
     * @param String txt 
     * @return
     */
    public void sendMessage(void Employee to, void String txt) {
        // TODO implement here
        return null;
    }

    /**
     * @param String txt 
     * @return
     */
    public void sendComplaint(void String txt) {
        // TODO implement here
        return null;
    }

}