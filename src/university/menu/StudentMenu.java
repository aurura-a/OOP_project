package university.menu;

import java.util.Scanner;
import university.model.Student;
import university.service.StudentService;

public class StudentMenu {
    private Student student;
    private StudentService service;
    private Scanner sc = new Scanner(System.in);

    public StudentMenu(Student student) {
        this.student = student;
        this.service = new StudentService();
    }

    public void display() {
        while (true) {
            System.out.println("\n1. View Marks\n2. Register for Course\n0. Logout");
            int choice = sc.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1: service.viewMarks(student); break;
                case 2: 
                    System.out.println("Enter course name:");
                    break;
            }
        }
    }
}