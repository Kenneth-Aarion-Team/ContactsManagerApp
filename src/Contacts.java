import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {


    // view contacts function
    public void viewContacts() throws IOException {

        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Input input = new Input();


        System.out.println("The user selected to view.");

        List<String> contactsList = Files.readAllLines(dataFile);

        String comp1 = "Contact Name";
        String comp2 = "Contact Number";
        String comp3 = "______";

        System.out.printf("%-24s%10s", "Name", "Phone Number");
        System.out.println();

        for (String contact : contactsList) {
            System.out.println(contact);
        }

        ContactsApp();
    }

    // add contacts function
    public void addContacts() throws IOException{
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Input input = new Input();
        Scanner sc = new Scanner(System.in);

        System.out.println("The user selected to add.");
        List<String> contactsContents = Files.readAllLines(dataFile);

        boolean makingName = true;
        String fullName;

        do {


            System.out.println("Enter the first name.");
            String contactFirst = input.getString();

            System.out.println("Enter the last name.");
            String contactLast = input.getString();

            fullName = contactFirst + " " + contactLast;

            int similarCount = 0;

            for (String contact : contactsContents) {
                if (contact.contains(fullName)) {
                    similarCount++;
                }
            }

            if (similarCount > 0) {
                System.out.println("Contact with the name " + fullName + " already exists. \nPlease enter a new name or delete the existing contact first.");
                ContactsApp();
            }
            if (similarCount == 0) {
                makingName = false;
            }

        } while (makingName);

        boolean needsToAddNumber = true;
        long contactNumber;
        do {

            System.out.println("Enter the contact's phone number.");

            contactNumber = sc.nextLong();

            if (contactNumber > 1000000) {
                needsToAddNumber = false;
            } else {
                System.out.println("Number is not valid, please enter again.");
            }
        } while (needsToAddNumber);

        String contactNumberStr = String.valueOf(contactNumber);

        if (contactNumberStr.length() == 7) {
            contactNumberStr = formatSeven(contactNumberStr);
        }

        if (contactNumberStr.length() == 10) {
            contactNumberStr = formatTen(contactNumberStr);
        }

        if (contactNumberStr.length() == 11) {
            contactNumberStr = formatEleven(contactNumberStr);
        }

        String sf = String.format( "%-22s%10s", fullName, contactNumberStr);

        String contactLine = fullName + " | " + contactNumberStr;


        contactsContents.add(sf);
        Files.write(dataFile, contactsContents);

        ContactsApp();
    }

    // search contacts function
    public void searchContacts() throws IOException {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Input input = new Input();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the name of the contact or the phone number to search for contact.");
        String userSearch = input.getString();

        List<String> contactsList = Files.readAllLines(dataFile);

        System.out.printf("%-24s%10s", "Name", "Phone Number");
        System.out.println();

        for (String contact : contactsList) {
            if (contact.contains(userSearch)) {
                System.out.println(contact);
            }
        }

        ContactsApp();
    }

    // delete contacts function
    public void deleteContact() throws IOException {

        String directory = "data";
        String filename = "contacts.txt";
        Input input = new Input();


        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        System.out.println("The user selected to delete.");

        List<String> contactsList = Files.readAllLines(dataFile);
        List<String> newContactsList = new ArrayList();


        System.out.println("Enter the name of the contact to delete.");

        String userToDelete = input.getString();

        System.out.printf("%-24s%10s", "Name", "Phone Number");
        System.out.println();
        for (String contact : contactsList) {
            if (contact.contains(userToDelete)) {
                System.out.println(contact);
            }
        }


        if (contactsList.contains(userToDelete)) {

        }
        System.out.println("Please confirm the full name of the user to delete.");

        userToDelete = input.getString();
        for (String contact : contactsList) {
            if (!contact.contains(userToDelete)) {
                newContactsList.add(contact);
            } else {
                System.out.println(contact + " was deleted.");
            }
        }

        Files.write(dataFile, newContactsList);

        ContactsApp();
    }

    // Main Contact App function
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

        System.out.println();
        System.out.println();

        System.out.println("Welcome to the ContactManagementSolutions App.");
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
                viewContacts();
            }

            // Add
            if (userSelection.toLowerCase().contains("add")) {
                addContacts();
            }

            // Search
            if (userSelection.toLowerCase().contains("search")) {
                searchContacts();
            }

            // Delete
            if (userSelection.toLowerCase().contains("delete")) {
                deleteContact();
            }

            // Exit
            if (userSelection.toLowerCase().contains("delete")) {
                System.out.println("The user selected to exit.");
                userWantsToContinue = false;
            }


        } while (userWantsToContinue);


    }

    // Phone Number Formatting - 7 digits
    public String formatSeven(String number) {

        int length = number.length();

        String sub1 = number.substring(0, 3);
        String sub2 = number.substring(3, length);

        String stringToReturn = sub1 + "-" + sub2;
        System.out.println(stringToReturn);
        return stringToReturn;

    }

    // Phone Number Formatting - 10 digits
    public String formatTen(String number) {

        int length = number.length();

        String sub1 = number.substring(0, 3);
        String sub2 = number.substring(3, 6);
        String sub3 = number.substring(6, length - 1);

        String stringToReturn = "(" + sub1 + ") " + sub2 + "-" + sub3;
        System.out.println(stringToReturn);
        return stringToReturn;

    }

    // Phone Number Formatting - 11 digits
    public String formatEleven(String number) {

        int length = number.length();

        String sub1 = number.substring(0, 3);
        String sub2 = number.substring(3, 6);
        String sub3 = number.substring(6, length);

        String stringToReturn = "+1 (" + sub1 + ") " + sub2 + "-" + sub3;
        System.out.println(stringToReturn);
        return stringToReturn;

    }
}
