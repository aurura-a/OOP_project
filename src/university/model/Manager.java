import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {

    private ManagerType type;
    private Set<Course> courses = new HashSet<>();

    public Manager() {
        super();
    }

    public Manager(String userId, String login, String password, String name, Lang lang,
                   double salary, ManagerType type) {
        super(userId, login, password, name, lang, salary);
        this.type = type;
    }

    @Override
    public void viewMenu() {
        System.out.println("Manager menu: approve registration, add courses, generate reports.");
    }

    public void approveRegistration(Request request) {
        System.out.println("Manager approved registration request: " + request);
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Manager added course: " + course);
    }

    public void generateReport() {
        System.out.println("Manager generated academic report.");
    }

    public ManagerType getType() {
        return type;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}