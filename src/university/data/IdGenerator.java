package university.data;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Generates sequential IDs per prefix.
 * Serializable — counters persist in Database.dat between runs.
 *
 * Usage:
 *   IdGenerator.next("USR")  →  "USR-0001", "USR-0002", ...
 *   IdGenerator.next("CRS")  →  "CRS-0001", ...
 *   IdGenerator.next("PRJ")  →  "PRJ-0001", ...
 *
 * Prefixes in use:
 *   USR = User
 *   CRS = Course
 *   PRJ = ResearchProject
 *   TCH = TechRequest
 *   MSG = Message
 *   JRN = Journal
 *   NWS = News
 */
public class IdGenerator implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private static int studentCount = 1;
    private static int teacherCount = 1;

    public static synchronized String generateId(String type) {
        if ("STUDENT".equalsIgnoreCase(type)) {
            return String.format("S%04d", studentCount++);
        } else if ("TEACHER".equalsIgnoreCase(type)) {
            return String.format("T%04d", teacherCount++);
        }
        return String.format("USR%04d", (int)(Math.random() * 10000));
    }
}