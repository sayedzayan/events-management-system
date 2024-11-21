// Class: EventsHashTable
import java.util.*;

public class EventsHashTable {
    private class Node {
        Event event;
        Node next;

        public Node(Event event) {
            this.event = event;
            this.next = null;
        }
    }

    private Node[] table;
    private static final int TABLE_SIZE = 367;  // Size of the hash table

    public EventsHashTable() {
        table = new Node[TABLE_SIZE];
    }

    private int hash(int day, int month, int year) {
        // Using getDayOfYear() to convert the date into a day number within the year
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public void addEvent(int day, int month, int year, String name) {
        int index = hash(day, month, year);
        Event newEvent = new Event(day, month, year, name);
        Node newNode = new Node(newEvent);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addAttendee(String eventName, int id, String name) {
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            while (current != null) {
                if (current.event.title.equals(eventName)) {
                    Attendee newAttendee = new Attendee(id, name);
                    current.event.addAttendee(newAttendee);
                    return;
                }
                current = current.next;
            }
        }
        System.out.println("Error: Event not found.");
    }

    public void removeEvent(String eventName) {
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            Node previous = null;
            while (current != null) {
                if (current.event.title.equals(eventName)) {
                    if (previous == null) {
                        table[i] = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
        }
        System.out.println("Error: Event not found.");
    }

    public ArrayList<String> attendeesList(int day, int month, int year) {
        ArrayList<String> result = new ArrayList<>();
        int index = hash(day, month, year);

        Node current = table[index];
        while (current != null) {
            result.addAll(current.event.attendeesList());
            current = current.next;
        }

        return result;
    }

    public ArrayList<String> attendeeEvents(int id) {
        ArrayList<String> events = new ArrayList<>();

        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            while (current != null) {
                if (current.event.search(id)) {
                    events.add(current.event.title);
                }
                current = current.next;
            }
        }

        return events;
    }
}
