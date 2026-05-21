package university.ui.views;

import university.data.Database;
import university.data.Session;
import university.ui.ConsoleUI;
import university.courses.Course;
import university.users.Teacher;
import university.users.Student;
import university.service.CourseService;

public class TeacherView {
    private Database db = Database.getInstance();
    private CourseService courseService = new CourseService();

    public void display() {
        Teacher teacher = (Teacher) Session.getCurrentUser();

        while (true) {
            System.out.println(Session.getString("teacher.header"));
            System.out.println(Session.getString("teacher.menu.view_courses"));
            System.out.println(Session.getString("common.logout"));

            int choice = ConsoleUI.readInt(">");
            if (choice == 1) {
                viewMyCoursesMenu(teacher);
            } else if (choice == 0) {
                Session.clear();
                break;
            }
        }
    }

    private void viewMyCoursesMenu(Teacher teacher) {
        while (true) {
            System.out.println(Session.getString("teacher.courses.header"));
            if (teacher.getCourses().isEmpty()) {
                System.out.println(Session.getString("teacher.courses.no_courses"));
                return;
            }

            for (int i = 0; i < teacher.getCourses().size(); i++) {
                Course c = teacher.getCourses().get(i);
                System.out.println((i + 1) + ". " + c.getName() + " [Students: " + c.getEnrolledStudents().size() + "]");
            }
            System.out.println(Session.getString("common.back"));
            
            System.out.print(Session.getString("teacher.courses.prompt_select"));
            int choice = ConsoleUI.readInt("");
            if (choice == 0) return;

            int idx = choice - 1;
            if (idx >= 0 && idx < teacher.getCourses().size()) {
                viewStudentsInCourseMenu(teacher.getCourses().get(idx));
            }
        }
    }

    private void viewStudentsInCourseMenu(Course course) {
        while (true) {
            ConsoleUI.printHeader("Students in " + course.getName());
            if (course.getEnrolledStudents().isEmpty()) {
            	System.out.println(Session.getString("teacher.students.no_students"));
                return;
            }

            for (int i = 0; i < course.getEnrolledStudents().size(); i++) {
                Student s = course.getEnrolledStudents().get(i);
                System.out.println((i + 1) + ". " + s.getFullname() + " [ID: " + s.getId() + "]");
            }
            System.out.println(Session.getString("common.back"));
            
            System.out.println(Session.getString("teacher.students.no_students"));
            
            int choice = ConsoleUI.readInt("Select student to grade:");
            if (choice == 0) return;

            int idx = choice - 1;
            if (idx >= 0 && idx < course.getEnrolledStudents().size()) {
                gradeStudentInterface(course.getEnrolledStudents().get(idx), course);
            }
        }
    }

    private void gradeStudentInterface(Student student, Course course) {
        ConsoleUI.printHeader("Grading: " + student.getFullname());
        System.out.println(Session.getString("teacher.grading.menu_att1"));
        System.out.println(Session.getString("teacher.grading.menu_att2"));
        System.out.println(Session.getString("teacher.grading.menu_exam"));
        System.out.println(Session.getString("common.cancel"));
        
        System.out.print(Session.getString("teacher.grading.prompt_type"));
        int attType = ConsoleUI.readInt(""); 
        if (attType < 1 || attType > 3) return;

        System.out.print(Session.getString("teacher.grading.prompt_points"));
        double points = 0;
        try {
            points = Double.parseDouble(ConsoleUI.readLine(""));
        } catch (Exception e) {
            System.out.println("Invalid number format.");
            return;
        }

        boolean success = courseService.gradeStudent(student, course, points, attType);
        if (success) {
            System.out.println("Grade updated successfully!");
        } else {
            System.out.println("Error: Student grade ledger not found.");
        }
    }
}