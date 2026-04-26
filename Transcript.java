import java.util.HashMap;

public class Transcript {
    private String studentName;
    private HashMap<Course, Mark> marks;

    public Transcript(String studentName) {
        this.studentName = studentName;
        marks = new HashMap<>();
    }

    public void addMark(Course course, Mark mark) {
        marks.put(course, mark);
    }

    public double calculateGPA() {
        if (marks.size() == 0) {
            return 0;
        }

        double sum = 0;

        for (Mark mark : marks.values()) {
            Grade grade = mark.getGrade();

            if (grade == Grade.A) sum += 4.0;
            else if (grade == Grade.B) sum += 3.0;
            else if (grade == Grade.C) sum += 2.0;
            else if (grade == Grade.D) sum += 1.0;
            else sum += 0.0;
        }

        return sum / marks.size();
    }

    public void printTranscript() {
        System.out.println("Transcript for " + studentName);

        for (Course course : marks.keySet()) {
            System.out.println(course + " -> " + marks.get(course));
        }

        System.out.println("GPA: " + calculateGPA());
    }
}