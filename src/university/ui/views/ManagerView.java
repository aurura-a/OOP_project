package university.ui.views;

import university.data.Database;
import university.data.Session;
import university.ui.ConsoleUI;
import university.courses.Course;
import university.courses.CourseType;
import university.users.User;
import university.users.Teacher;
import university.service.CourseService;

public class ManagerView {
    private Database db = Database.getInstance();
    private CourseService courseService = new CourseService();

    public void display() {
        while (true) {
            ConsoleUI.printHeader("Manager Workspace");
            System.out.println("1. Create New Course");
            System.out.println("2. Assign Teacher to Course");
            System.out.println("0. Logout");

            int choice = ConsoleUI.readInt(">");
            if (choice == 1) {
                createNewCourseMenu();
            } else if (choice == 2) {
                assignTeacherMenu();
            } else if (choice == 0) {
                Session.clear();
                break;
            }
        }
    }

    private void createNewCourseMenu() {
        ConsoleUI.printHeader("Create Course");
        String id = ConsoleUI.readLine("Enter Course Code (e.g., CS102):");
        String name = ConsoleUI.readLine("Enter Course Name:");
        int credits = ConsoleUI.readInt("Enter Credits:");
        
        // Добавляем выбор типа курса, чтобы конструктор не ругался
        System.out.println("Select Course Type:");
        System.out.println("1. MAJOR");
        System.out.println("2. ELECTIVE");
        int typeChoice = ConsoleUI.readInt(">");
        
        university.courses.CourseType type = university.courses.CourseType.MAJOR;
        if (typeChoice == 2) {
            type = university.courses.CourseType.FREE;
        }

        // Проверяем уникальность кода курса
        boolean exists = false;
        for (Course c : db.getCourses()) {
            if (c.getId().equalsIgnoreCase(id)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            // ИСПРАВЛЕНО: Теперь передаем 4 параметра, включая тип курса!
            Course newCourse = new Course(id, name, credits, type);
            db.getCourses().add(newCourse);
            System.out.println("Course successfully created!");
        } else {
            System.out.println("Error: Course with this code already exists.");
        }
    }

    private void assignTeacherMenu() {
        ConsoleUI.printHeader("Assign Teacher to Course");
        if (db.getCourses().isEmpty()) {
            System.out.println("No courses available. Create a course first.");
            return;
        }

        // 1. Выбираем курс
        System.out.println("Select Course:");
        for (int i = 0; i < db.getCourses().size(); i++) {
            System.out.println((i + 1) + ". " + db.getCourses().get(i).getName());
        }
        int courseIdx = ConsoleUI.readInt(">") - 1;
        if (courseIdx < 0 || courseIdx >= db.getCourses().size()) return;
        Course selectedCourse = db.getCourses().get(courseIdx);

        // 2. Собираем список учителей
        java.util.Vector<Teacher> teachers = new java.util.Vector<>();
        for (User u : db.getUsers().values()) {
            if (u instanceof Teacher) {
                teachers.add((Teacher) u);
            }
        }

        if (teachers.isEmpty()) {
            System.out.println("No teachers registered in the system.");
            return;
        }

        // 3. Выбираем преподавателя
        System.out.println("Select Teacher to assign:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getFullname());
        }
        int teacherIdx = ConsoleUI.readInt(">") - 1;
        if (teacherIdx < 0 || teacherIdx >= teachers.size()) return;
        Teacher selectedTeacher = teachers.get(teacherIdx);

        // Вызываем новый метод двустороннего связывания из CourseService
        courseService.assignTeacherToCourse(selectedTeacher, selectedCourse);
        System.out.println("Successfully assigned Prof. " + selectedTeacher.getLastName() + " to " + selectedCourse.getName());
    }
}