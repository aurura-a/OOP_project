package university.users;

import university.courses.Course;
import university.courses.Transcript;
import university.users.enums.TeacherPosition;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private static final long serialVersionUID = 1L;

    private TeacherPosition position;
    private List<Course> courses = new ArrayList<>();

    public Teacher(String id, String firstName, String lastName, String login, String password, String preferredLanguage, String department, double salary, TeacherPosition position) {
        super(id, firstName, lastName, login, password, preferredLanguage,department, salary);
        this.department = department;
        this.position = position;
    }

    public TeacherPosition getPosition() { return position; }
    public void setPosition(TeacherPosition position) { this.position = position; }

    public List<Course> getCourses() { 
        return courses; 
    }

    public void assignCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            this.courses.add(course);
        }
    }

    public void removeCourse(Course course) {
        if (course != null) {
            this.courses.remove(course);
        }
    }
   

    @Override
    public String asLine() {
        return super.asLine() + " | Position: " + position + " | Courses: " + courses.size();
    }
}