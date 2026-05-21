package university.ui.views;

import university.data.Database;
import university.data.Session;
import university.ui.ConsoleUI;
import university.courses.Course;
import university.courses.Mark;
import university.users.Student;
import university.service.CourseService;

public class StudentView {
    private Database db = Database.getInstance();
    private CourseService courseService = new CourseService();

    public void display() {
        Student student = (Student) Session.getCurrentUser();

        while (true) {
            ConsoleUI.printHeader("Student Workspace — " + student.getFullname());
            System.out.println("1. View and Register for Courses");
            System.out.println("2. View My Performance (Transcript)");
            System.out.println("0. Logout");

            int choice = ConsoleUI.readInt(">");
            if (choice == 1) {
                viewAndRegisterCoursesMenu(student);
            } else if (choice == 2) {
                viewTranscript(student);
            } else if (choice == 0) {
                Session.clear();
                break;
            }
        }
    }

    private void viewAndRegisterCoursesMenu(Student student) {
        while (true) {
            ConsoleUI.printHeader("Available Courses in University");
            if (db.getCourses().isEmpty()) {
                System.out.println("No courses available in the database.");
                return;
            }

            for (int i = 0; i < db.getCourses().size(); i++) {
                Course c = db.getCourses().get(i);
                System.out.println((i + 1) + ". " + c.getName() + " [" + c.getId() + "] (" + c.getCredits() + " Credits)");
                System.out.println("   Instructors: " + (c.getInstructors().isEmpty() ? "None assigned yet" : ""));
                for (university.users.Teacher t : c.getInstructors()) {
                    System.out.println("     * Prof. " + t.getLastName());
                }
            }
            System.out.println("0. Back");

            int choice = ConsoleUI.readInt("Select course number to Register:");
            if (choice == 0) return;

            int idx = choice - 1;
            if (idx >= 0 && idx < db.getCourses().size()) {
                Course selectedCourse = db.getCourses().get(idx);
                boolean success = courseService.registerStudentToCourse(student, selectedCourse);
                if (success) {
                    System.out.println("Successfully registered for " + selectedCourse.getName() + "!");
                } else {
                    System.out.println("Registration failed! (Check credit limits or if you're already registered).");
                }
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private void viewTranscript(Student student) {
        ConsoleUI.printHeader("My Performance & Marks");
        boolean hasMarks = false;

        for (Mark m : db.getMarks()) {
            if (m.getStudent().equals(student)) {
                System.out.println(m.asLine());
                hasMarks = true;
            }
        }

        if (!hasMarks) {
            System.out.println("You are not registered to any courses or have no grades yet.");
        }
    }
}