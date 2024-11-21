/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
// Class: Event
public class Event {
    int day, month, year;
    String title;
    BSTree attendees;  // BST for storing attendees by their ID

    public Event(int day, int month, int year, String title) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.title = title;
        this.attendees = new BSTree();  // Initializes an empty BST for attendees
    }

    public void addAttendee(Attendee a) {
        attendees.insert(a);
    }

    public boolean search(int id) {
        return attendees.search(id);
    }

    public ArrayList<String> attendeesList() {
        ArrayList<String> list = new ArrayList<>();
        attendees.preOrder(list);  // Using pre-order traversal to collect attendees' names
        return list;
    }
}
