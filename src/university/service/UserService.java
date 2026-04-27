package university.service;
import university.model.*;
import university.util.IdGenerator;
import java.util.ArrayList;

public class UserService {
    
    public Student registerStudent(String name, String login, String password, ArrayList<User> allUsers) {
        for (User u : allUsers) {
            if (u.getLogin().equals(login)) {
                System.out.println("Error: Login exists!");
                return null;
            }
        }
        
        String id = IdGenerator.generateId("STUDENT");
        Student newStudent = new Student(id, login, password, name);
        allUsers.add(newStudent);
        return newStudent;
    }

    public User login(String login, String password, ArrayList<User> allUsers) {
        for (User u : allUsers) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null; 
    }
}