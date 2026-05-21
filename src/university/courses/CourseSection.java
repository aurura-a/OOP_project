package university.courses;

import java.io.Serializable;
import java.util.Vector;
import university.users.Teacher;
import university.users.Student;

public class CourseSection implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sectionId;
    private Course course;
    private Teacher lecturer;
    private Teacher practitioner;
    private int maxSeats;
    private Vector<Student> enrolledStudents;

    public CourseSection(String sectionId, Course course, Teacher lecturer, Teacher practitioner, int maxSeats) {
        this.sectionId = sectionId;
        this.course = course;
        this.lecturer = lecturer;
        this.practitioner = practitioner;
        this.maxSeats = maxSeats;
        this.enrolledStudents = new Vector<>();
    }

    public String getSectionId() { return sectionId; }
    public Course getCourse() { return course; }
    public Teacher getLecturer() { return lecturer; }
    public Teacher getPractitioner() { return practitioner; }
    public int getMaxSeats() { return maxSeats; }
    public Vector<Student> getEnrolledStudents() { return enrolledStudents; }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxSeats) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }
}
