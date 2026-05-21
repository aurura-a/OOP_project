package university.service;

import university.users.User;
import university.users.Student;
import university.users.Teacher;
import university.users.Manager;
import university.users.enums.DegreeType;
import university.users.enums.TeacherPosition;
import university.data.IdGenerator;
import java.util.Map;

public class AuthService {
	public User login(String login, String password, Map<String, User> allUsers) {
	    User user = allUsers.get(login);
	    
	    // Если пользователь найден и пароль совпадает — возвращаем его
	    if (user != null && user.getPassword().equals(password)) {
	        return user;
	    }
	    
	    // Если логина нет или пароль неверный — возвращаем null
	    return null; 
	}

    public Student registerStudent(String firstName, String lastName, String login, String password, String lang, Map<String, User> allUsers) {
        if (allUsers.containsKey(login)) return null;

        String id = IdGenerator.generateId("STU");
        // Вызываем новый конструктор: id, firstName, lastName, login, password, lang, degree, year
        Student student = new Student(id, firstName, lastName, login, password, lang, DegreeType.BACHELOR, 1);
        
        allUsers.put(login, student);
        return student;
    }

    public Teacher registerTeacher(String firstName, String lastName, String login, String password, String lang, Map<String, User> allUsers) {
        if (allUsers.containsKey(login)) return null;

        String id = IdGenerator.generateId("TCH");
        // Вызываем новый конструктор: id, firstName, lastName, login, password, lang, department, salary, position
        Teacher teacher = new Teacher(id, firstName, lastName, login, password, lang, "FIT", 500000.0, TeacherPosition.TUTOR_LECTOR);
        
        allUsers.put(login, teacher);
        return teacher;
    }

    public Manager registerManager(String firstName, String lastName, String login, String password, String lang, Map<String, User> allUsers) {
        if (allUsers.containsKey(login)) return null;

        String id = IdGenerator.generateId("MGR");
        Manager manager = new Manager(id, firstName, lastName, login, password, lang, "Office of Registrar", 400000.0);
        
        allUsers.put(login, manager);
        return manager;
    }
}