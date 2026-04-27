package university.util;
import university.model.*;

public class IdGenerator {
    public static String generateId(String role) {
        String prefix = "";
        switch (role.toUpperCase()) {
            case "STUDENT": prefix = "S"; break;
            case "TEACHER": prefix = "ET"; break;
            case "MANAGER": prefix = "EM"; break;
            default: prefix = "U";
        }
        
        int randomPart = (int)(Math.random() * 900000) + 100000; 
        
        return prefix + randomPart;
    }
}