package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {
        String input = scanner.nextLine();
        return input;
    }

    public boolean yesNo() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
            return false;
        } else {
            return yesNo();
        }
    }

    public int getInt() {

//        System.out.println("Enter an integer.");
//            int input = scanner.nextInt();
//        System.out.println(input);
        try {

            String input = getString();

            int inputInt = Integer.valueOf(input);

            return inputInt;
        } catch (Exception e) {
            System.out.println("Enter an integer.");
        }
        return getInt();
    }

    public double getDouble() {
//        System.out.println("Enter a decimal.");
        try {

            String input = getString();

            double inputInt = Double.valueOf(input);

            return inputInt;
        } catch (Exception e) {
            System.out.println("Enter a double.");
        }
        return getDouble();
    }


    public int getInt(int min, int max) {
        System.out.println("Please enter an int between " + min + " and " + max + ".");
        int input = getInt();
        if (input >= min && input <= max) {
//            System.out.println(input);
            return input;
        } else {
            return getInt(min, max);
        }
    }

    public double getDouble(double min, double max) {
        System.out.println("Please enter a decimal between " + min + " and " + max + ".");
        double input = getDouble();
        if (input >= min && input <= max) {
//            System.out.println(input);
            return input;
        } else {
            return getDouble(min, max);
        }
    }





    public static void main(String[] args) {

    }
}
