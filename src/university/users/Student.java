package university.users;

import university.courses.Course;
import university.courses.Transcript;
import university.users.enums.DegreeType;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private static final long serialVersionUID = 1L;

    private DegreeType degree;
    private int year;
    private int credits;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Transcript transcript;

    public Student(String id, String firstName, String lastName, String login, String password, String preferredLanguage, DegreeType degree, int year) {
        super(id, firstName, lastName, login, password, preferredLanguage);
        this.degree = degree;
        this.year = year;
        this.credits = 0;
    }

    public DegreeType getDegree() { return degree; }
    public int getYear() { return year; }
    public int getCredits() { return credits; }
    public List<Course> getEnrolledCourses() { return enrolledCourses; }

    public boolean registerForCourse(Course course) {
        if (course == null) return false;
        
        // Если студент уже зарегистрирован, ничего не делаем
        if (enrolledCourses.contains(course)) {
            return false; 
        }

        // Проверяем лимит кредитов (например, не больше 21 по контракту)
        if (this.credits + course.getCredits() > 21) {
            return false; 
        }

        this.enrolledCourses.add(course);
        this.credits += course.getCredits();

        // Двустороннее связывание: добавляем студента в сам курс
        if (!course.getEnrolledStudents().contains(this)) {
            course.addStudent(this);
        }
        return true;
    }

    public void dropCourse(Course course) {
        if (course != null && enrolledCourses.contains(course)) {
            this.enrolledCourses.remove(course);
            this.credits -= course.getCredits();
            course.removeStudent(this);
        }
    }

	public Transcript getTranscript() {
		return transcript;
	}

}