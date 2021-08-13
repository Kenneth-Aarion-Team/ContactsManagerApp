import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Input input = new Input();

        String directory = "data";
        String filename = "contacts.txt";

        ArrayList<String> contactsContents = new ArrayList<>();

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }

        // Boolean used to determine if application should keep running

        boolean userWantsToContinue = true;

        // Initial application running, prints existing contacts

        System.out.println("Welcome to the ContactManagementSolutions App.");
        System.out.println("Here is your current list of contacts.");
        System.out.println(contactsContents);

        // Initial user selection

        do {

            System.out.println("Please enter select from the options below.");
            System.out.println("-view contacts");
            System.out.println("-add contacts");
            System.out.println("-search contacts");
            System.out.println("-delete contact");
            System.out.println("-exit program");

            String userSelection = input.getString();

            // View
            if (userSelection.toLowerCase().contains("view")) {
                System.out.println("The user selected to view.");
            }

            // Add
            if (userSelection.toLowerCase().contains("add")) {
                System.out.println("The user selected to add.");
            }

            // Search
            if (userSelection.toLowerCase().contains("search")) {
                System.out.println("The user selected to search.");
            }

            // Delete
            if (userSelection.toLowerCase().contains("delete")) {
                System.out.println("The user selected to delete.");
            }

            // Exit
            if (userSelection.toLowerCase().contains("delete")) {
                System.out.println("The user selected to exit.");
                userWantsToContinue = false;
            }

        } while (userWantsToContinue);



    }


}
