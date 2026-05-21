package university.app;

import university.data.Database;
import university.ui.views.AutView;
import university.users.Teacher;
import university.users.enums.TeacherPosition;
import university.courses.Course;

public class MainApp {
    public static void main(String[] args) {
        // Инициализация базы данных и демо-данных
        initTestData();

        // Запуск экрана авторизации
        AutView authView = new AutView();
        authView.display();

        // Перед полным закрытием сохраняем базу в файл database.dat
        Database.getInstance().saveData();
        System.out.println("System closed cleanly.");
    }

    private static void initTestData() {
        Database db = Database.getInstance();
        
        // Если база пустая, наполняем её демо-данными
        if (db.getCourses().isEmpty()) {
            // 1. Создаем менеджера (Логин: "manager", Пароль: "123")
            university.users.Manager manager = new university.users.Manager(
                "MGR-0001", "Office", "Registrar", "manager", "123", "en", "OR", 500000
            );
            db.getUsers().put(manager.getLogin(), manager);

            // 2. Создаем двух преподавателей (Избасар и Торехан)
            university.users.Teacher t1 = new university.users.Teacher(
                "TCH-0001", "Izbasar", "Lecturer", "Izbasar", "123", "en", "SITE", 600000, university.users.enums.TeacherPosition.PROFESSOR
            );
            university.users.Teacher t2 = new university.users.Teacher(
                "TCH-0002", "Torehan", "Practitioner", "Torehan", "123", "en", "SITE", 450000, university.users.enums.TeacherPosition.TUTOR_LECTOR
            );
            db.getUsers().put(t1.getLogin(), t1);
            db.getUsers().put(t2.getLogin(), t2);

            // 3. Создаем курс ООП
            university.courses.Course oop = new university.courses.Course(
                "CS102", "Object-Oriented Programming", 5, university.courses.CourseType.MAJOR
            );
            db.getCourses().add(oop);
            
            System.out.println(">>> Demo data seeded successfully! <<<");
        }
    }
}