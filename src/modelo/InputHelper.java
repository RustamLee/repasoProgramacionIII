package modelo;

import java.util.Scanner;

public class InputHelper {

        private static final Scanner scanner = new Scanner(System.in); // Один Scanner для всего класса

        public static String input(String parametro) {
            System.out.print("Ingrese " + parametro + ": ");
            return scanner.nextLine();
        }

}
