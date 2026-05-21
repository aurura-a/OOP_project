package university.ui.views;

import java.util.Locale;
import university.data.Database;
import university.data.Session;
import university.service.AuthService;
import university.ui.ConsoleUI;
import university.users.User;

public class AutView {
    private AuthService authService = new AuthService();
    private Database db = Database.getInstance();

    public void display() {
        chooseLanguage();

        while (true) {
            ConsoleUI.printHeader(Session.getString("welcome"));
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("0. Exit");
            
            int choice = ConsoleUI.readInt(">");

            if (choice == 1) {
                signIn();
            } else if (choice == 2) {
                signUp();
            } else if (choice == 0) {
                break;
            }
        }
    }

    private void chooseLanguage() {
        System.out.println("Select Language / Выберите язык / Тіл таңдаңыз:");
        System.out.println("1. English\n2. Русский\n3. Қазақша");
        int lang = ConsoleUI.readInt(">");
        if (lang == 2) Session.setLocale(new Locale("ru"));
        else if (lang == 3) Session.setLocale(new Locale("kz"));
        else Session.setLocale(new Locale("en"));
    }

    private void signIn() {
        ConsoleUI.printHeader("Sign In");
        String login = ConsoleUI.readLine(Session.getString("login_prompt"));
        String password = ConsoleUI.readLine(Session.getString("pass_prompt"));

        User user = authService.login(login, password, db.getUsers());
        if (user != null) {
            Session.setCurrentUser(user);
            System.out.println("Successfully logged in! Welcome, " + user.getFullname());
            
            // Перенаправление в зависимости от роли
            if (user instanceof university.users.Student) {
                new StudentView().display();
            } else if (user instanceof university.users.Teacher) {
            	new TeacherView().display();
            }else if (user instanceof university.users.Manager) {
            	new ManagerView().display();
            }
        } else {
            System.out.println("Error: Invalid login or password.");
        }
    }

    private void signUp() {
        ConsoleUI.printHeader("Sign Up");
        System.out.println(Session.getString("choose_role"));
        String role = ConsoleUI.readLine(">").toUpperCase();
        System.out.print(Session.getString("enter_fname"));
        String firstName = ConsoleUI.readLine("");
        System.out.print(Session.getString("enter_lname"));
        String lastName = ConsoleUI.readLine("");
        System.out.print(Session.getString("enter_login"));
        String login = ConsoleUI.readLine("");
        System.out.print(Session.getString("enter_password"));
        String password = ConsoleUI.readLine("");

        User newUser = null;
        if ("S".equals(role)) {
            newUser = authService.registerStudent(firstName, lastName, login, password, "EN", db.getUsers());
        } else if ("T".equals(role)) {
            newUser = authService.registerTeacher(firstName, lastName, login, password, "EN", db.getUsers());
        }else if ("M".equals(role)) {
            newUser = authService.registerManager(firstName, lastName, login, password, "EN", db.getUsers());
        }

        if (newUser != null) {
            // Твоя прихоть: вместо отправки назад, логиним автоматически!
            Session.setCurrentUser(newUser); 
            System.out.println(Session.getString("login_success", newUser.getFullname()));
            
            // Сразу перенаправляем в рабочую зону
            if (newUser instanceof university.users.Student) {
                new StudentView().display();
            } else if (newUser instanceof university.users.Teacher) {
            	new TeacherView().display(); // Этот класс будет в следующем шаге
            } else if (newUser instanceof university.users.Manager) {
                new ManagerView().display();
            }
        } else {
            System.out.println("Error: Login already exists.");
        }
    }
}

