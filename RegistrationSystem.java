import java.util.ArrayList;

public class RegistrationSystem {
    private int maxCredits = 21;

    public void registerStudent(String studentName, Course course,
                                ArrayList<String> completedCourses,
                                ArrayList<Course> currentCourses)
            throws CourseFullException, PrerequisiteException {

        int totalCredits = 0;

        for (Course c : currentCourses) {
            totalCredits += c.getCredits();
        }

        if (totalCredits + course.getCredits() > maxCredits) {
            System.out.println("Student cannot register more than 21 credits");
            return;
        }

        course.addStudent(studentName, completedCourses);
        currentCourses.add(course);

        System.out.println(studentName + " registered to " + course);
    }
}