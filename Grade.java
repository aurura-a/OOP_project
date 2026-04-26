import java.util.ArrayList;

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

    public void addPrerequisite(String courseName) {
        prerequisites.add(courseName);
    }

    public boolean isFull() {
        return students.size() >= capacity;
    }

    public void addStudent(String studentName, ArrayList<String> completedCourses)
            throws CourseFullException, PrerequisiteException {

        if (isFull()) {
            throw new CourseFullException();
        }

        for (String pre : prerequisites) {
            if (!completedCourses.contains(pre)) {
                throw new PrerequisiteException();
            }
        }

        students.add(studentName);
    }

    public int getCredits() {
        return credits;
    }

    public String toString() {
        return name + " (" + credits + " credits)";
    }
}