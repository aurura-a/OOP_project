package university.users;
import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {
    private static final long serialVersionUID = 1L;

    public Manager(String id, String firstName, String lastName, String login, String password, String preferredLanguage, String department, double salary) {
        super(id, firstName, lastName, login, password, preferredLanguage, department, salary);
    }
}