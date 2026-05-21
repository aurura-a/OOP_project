package university.courses;

import university.data.SerializableModel;
import university.users.Student;
import university.users.Teacher;
import java.util.ArrayList;
import java.util.List;

public class Course extends SerializableModel {
    private static final long serialVersionUID = 1L;

    private String name;
    private int credits;
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<Teacher> instructors = new ArrayList<>();
	private CourseType type; 

	public Course(String id, String name, int credits, university.courses.CourseType type) {
	    this.id = id; 
	    this.name = name;
	    this.credits = credits;
	}

    public String getName() { return name; }
    public int getCredits() { return credits; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public List<Teacher> getInstructors() { return instructors; }

    // Логика связывания со Студентом
    public void addStudent(Student student) {
        if (student == null) return;
        if (!enrolledStudents.contains(student)) {
            this.enrolledStudents.add(student);
        }
        if (!student.getEnrolledCourses().contains(this)) {
            student.registerForCourse(this);
        }
    }

    public void removeStudent(Student student) {
        if (student == null) return;
        if (enrolledStudents.contains(student)) {
            this.enrolledStudents.remove(student);
            student.dropCourse(this);
        }
    }

    // Логика прикрепления Учителя Менеджером
    public void addInstructor(Teacher teacher) {
        if (teacher == null) return;
        if (!instructors.contains(teacher)) {
            this.instructors.add(teacher);
        }
        // Учитель тоже должен узнать, что ему дали этот курс
        if (!teacher.getCourses().contains(this)) {
            teacher.assignCourse(this);
        }
    }
    
    public void removeInstructor(Teacher teacher) {
        if (teacher == null) return;
        if (instructors.contains(teacher)) {
            this.instructors.remove(teacher);
            teacher.removeCourse(this);
        }
    }

    @Override
    public String asLine() {
        return String.format("Course ID: %s | %s (%d Credits) | Students: %d", 
                id, name, credits, enrolledStudents.size());
    }

    @Override
    public String asTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Code: ").append(id).append("\n");
        sb.append("Title: ").append(name).append("\n");
        sb.append("Credits: ").append(credits).append("\n");
        sb.append("Instructors count: ").append(instructors.size()).append("\n");
        sb.append("Enrolled Students: ").append(enrolledStudents.size()).append("\n");
        return sb.toString();
    }
}