package view;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputOption(String field) {
        System.out.printf("Opção de %s: ", field);
        Integer option = scanner.nextInt();
        return option;
    }

    public static void treatException() {
        scanner.nextLine();
    }
}
