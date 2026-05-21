package university.ui;

import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printHeader(String title) {
        System.out.println("\n=================================");
        System.out.println("   " + title.toUpperCase());
        System.out.println("=================================");
    }

    public static String readLine(String prompt) {
        System.out.print(prompt + " ");
        return scanner.next();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt + " ");
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}