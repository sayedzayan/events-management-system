/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author welcome
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Team name: [Team Name]
        Scanner scanner = new Scanner(System.in);
        EventsHashTable eventsTable = new EventsHashTable();

        // Try to load the data from the file (if exists)
        // Add the necessary code to load the serialized object

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1- Add a new event.");
            System.out.println("2- Register attendee in an event");
            System.out.println("3- Display attendees list in a specific day");
            System.out.println("4- Display attendee’s events.");
            System.out.println("5- Remove an event.");
            System.out.println("6- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new event
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter day (1-31): ");
                    int day = scanner.nextInt();
                    System.out.print("Enter month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    eventsTable.addEvent(day, month, year, eventName);
                    break;

                case 2:
                    // Register attendee
                    System.out.print("Enter event name: ");
                    eventName = scanner.nextLine();
                    System.out.print("Enter attendee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter attendee name: ");
                    String name = scanner.nextLine();
                    eventsTable.addAttendee(eventName, id, name);
                    break;

                case 3:
                    // Display attendees list
                    System.out.print("Enter day: ");
                    day = scanner.nextInt();
                    System.out.print("Enter month: ");
                    month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    year = scanner.nextInt();
                    ArrayList<String> attendees = eventsTable.attendeesList(day, month, year);
                    System.out.println("Attendees: " + attendees);
                    break;

                case 4:
                    // Display attendee’s events
                    System.out.print("Enter attendee ID: ");
                    id = scanner.nextInt();
                    ArrayList<String> events = eventsTable.attendeeEvents(id);
                    System.out.println("Events: " + events);
                    break;

                case 5:
                    // Remove event
                    System.out.print("Enter event name to remove: ");
                    eventName = scanner.nextLine();
                    eventsTable.removeEvent(eventName);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
