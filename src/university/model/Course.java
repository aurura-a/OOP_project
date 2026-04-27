package university.model;

import java.util.ArrayList;

import university.exceptions.CourseFullException;

public class Course {
    private String name;
    private int credits;
    private int capacity;

    private ArrayList<String> students;
    private ArrayList<String> prerequisites;

    public Course(String name, int credits, int capacity) {
        this.name = name;
        this.credits = credits;
        this.capacity = capacity;
        students = new ArrayList<>();
        prerequisites = new ArrayList<>();
    }

    public String toString() {
        return name + " (" + credits + " credits)";
    }
    public ArrayList<String> getStudents() { return students; }
    public ArrayList<String> getPrerequisites() { return prerequisites; }
    public int getCapacity() { return capacity; }
    public int getCredits() { return credits; }
    public String getName() { return name; }
}