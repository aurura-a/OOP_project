
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    public Course() {
    }

    /**
     * 
     */
    private String courseCode;

    

	/**
     * 
     */
    private String courseName;

    /**
     * 
     */
    private int credits;

    /**
     * 
     */
    private Set<Course> Course;

    /**
     * 
     */
    public Student *;



    /**
     * @return
     */
    public String getCourseInfo() {
        // TODO implement here
        return "";
    }
    
    
    /**GETTERS & SETTERS**/
    public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Set<Course> getCourse() {
		return Course;
	}

	public void setCourse(Set<Course> course) {
		Course = course;
	}
}