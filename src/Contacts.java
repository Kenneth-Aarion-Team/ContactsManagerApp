import util.Input;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {



    public void ContactsApp() throws IOException {

        Scanner sc = new Scanner(System.in);

        Input input = new Input();

        String directory = "data";
        String filename = "contacts.txt";



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
//        System.out.println(contactsContents);

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

                List<String> contactsList = Files.readAllLines(dataFile);

                for (String contact : contactsList) {
                    System.out.println(contact);
                }
            }

            // Add
            if (userSelection.toLowerCase().contains("add")) {
                System.out.println("The user selected to add.");

                System.out.println("Enter the first name.");
                String contactFirst = input.getString();

                System.out.println("Enter the last name.");
                String contactLast = input.getString();

                System.out.println("Enter the contact's phone number.");
                long contactNumber = sc.nextLong();
                String contactNumberStr = String.valueOf(contactNumber);

                String contactLine = contactFirst + " " + contactLast + " | " + contactNumberStr;

                List<String> contactsContents = Files.readAllLines(dataFile);
                contactsContents.add(contactLine);
                Files.write(dataFile, contactsContents);


            }

            // Search
            if (userSelection.toLowerCase().contains("search")) {
                System.out.println("The user selected to search.");
            }

            // Delete
            if (userSelection.toLowerCase().contains("delete")) {
                System.out.println("The user selected to delete.");

                List<String> contactsList = Files.readAllLines(dataFile);

                System.out.println("Enter the name of the contact to delete.");

                String userToDelete = input.getString();

                for (String contact : contactsList) {
                    if (contact.contains(userToDelete)) {
                        System.out.println(contact);
                    }
                }

                System.out.println("Please confirm the full name of the user to delete.");

                userToDelete = input.getString();


                int userToDeleteIndex = 0;

                if (contactsList.contains(userToDelete)) {
                    userToDeleteIndex = contactsList.indexOf(userToDelete);
                }
                contactsList.remove(userToDeleteIndex);
                System.out.println("User was deleted.");
                Files.write(dataFile, contactsList);
                ContactsApp();

            }

            // Exit
            if (userSelection.toLowerCase().contains("delete")) {
                System.out.println("The user selected to exit.");
                userWantsToContinue = false;
            }

        } while (userWantsToContinue);


    }

}
