package university.exceptions;
public class CourseFullException extends Exception {
    public CourseFullException() {
        super("Course is full");
    }
}