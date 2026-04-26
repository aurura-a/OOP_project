import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Course oop = new Course("OOP", 5, 2);
            Course database = new Course("Database", 5, 2);

            database.addPrerequisite("OOP");

            ArrayList<String> completedCourses = new ArrayList<>();
            completedCourses.add("OOP");

            ArrayList<Course> currentCourses = new ArrayList<>();

            RegistrationSystem system = new RegistrationSystem();
            system.registerStudent("Aruzhan", database, completedCourses, currentCourses);

            Mark mark = new Mark(30, 25, 35);

            Transcript transcript = new Transcript("Aruzhan");
            transcript.addMark(database, mark);
            transcript.printTranscript();

        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
        } catch (PrerequisiteException e) {
            System.out.println(e.getMessage());
        }
    }
}