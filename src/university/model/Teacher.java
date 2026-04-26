import java.util.HashSet;
import java.util.Set;

public class Teacher extends Employee {

    private TeacherTitle title;
    private Set<Course> courses = new HashSet<>();

    public Teacher() {
        super();
    }

    public Teacher(String userId, String login, String password, String name, Lang lang,
                   double salary, TeacherTitle title) {
        super(userId, login, password, name, lang, salary);
        this.title = title;
    }

    @Override
    public void viewMenu() {
        System.out.println("Teacher menu: view courses, manage course, put marks, send complaint.");
    }

    public void putMark(Student student, Course course, Mark mark) {
        System.out.println("Teacher " + name + " put mark for " + student.getName() + " in course " + course);
    }

    public void manageCourse(Course course) {
        courses.add(course);
        System.out.println("Teacher " + name + " manages course: " + course);
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}