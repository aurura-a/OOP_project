package university.app;

import java.util.Scanner;
import university.model.*;
import university.service.UserService;
import university.menu.StudentMenu;
import java.util.ArrayList;

public class MainApp {
    private static ArrayList<User> users = new ArrayList<>(); 
    private static UserService userService = new UserService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to University System!");

        while (true) {
            System.out.println("1. Login\n2. Sign Up\n0. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Login: "); String log = sc.next();
                System.out.println("Pass: "); String pass = sc.next();

                User user = userService.login(log, pass, users);
                if (user != null) {
                    handleUserMenu(user);
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else if (choice == 2) {
            	
            } else if (choice == 0) break;
        }
    }

    private static void handleUserMenu(User user) {
        if (user instanceof Student) {
            new StudentMenu((Student) user).display();
        } else if (user instanceof Teacher) {
        }
    }
}