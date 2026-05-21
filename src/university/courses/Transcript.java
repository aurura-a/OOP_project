package university.courses;

import java.io.Serializable;
import java.util.Vector;

public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;

    private Vector<Mark> marks;
    private double gpa;

    public Transcript() {
        this.marks = new Vector<>();
        this.gpa = 0.0;
    }

    public Vector<Mark> getMarks() { return marks; }
    public double getGpa() { return gpa; }

    public void calculateGPA() {
        if (marks.isEmpty()) { this.gpa = 0.0; return; }
        double totalPoints = 0;
        for (Mark m : marks) {
            String grade = m.getLetterGrade();
            if (grade.startsWith("A")) totalPoints += 4.0;
            else if (grade.startsWith("B")) totalPoints += 3.0;
            else if (grade.startsWith("C")) totalPoints += 2.0;
            else if (grade.startsWith("D")) totalPoints += 1.0;
        }
        this.gpa = totalPoints / marks.size();
    }
}