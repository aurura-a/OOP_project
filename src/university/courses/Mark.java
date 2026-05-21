package university.courses;

import university.data.SerializableModel;
import university.users.Student;

public class Mark extends SerializableModel {
    private static final long serialVersionUID = 1L;

    private Student student;
    private Course course;
    private double att1;
    private double att2;
    private double finalExam;

    public Mark(String id, Student student, Course course) {
        this.id = id; // Генерируется как MRK-XXXX
        this.student = student;
        this.course = course;
        this.att1 = 0.0;
        this.att2 = 0.0;
        this.finalExam = 0.0;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }

    public double getAtt1() { return att1; }
    public void setAtt1(double att1) { this.att1 = att1; }

    public double getAtt2() { return att2; }
    public void setAtt2(double att2) { this.att2 = att2; }

    public double getFinalExam() { return finalExam; }
    public void setFinalExam(double finalExam) { this.finalExam = finalExam; }

    public double getTotal() {
        return att1 + att2 + finalExam;
    }

    public String getLetterGrade() {
        double total = getTotal();
        if (total >= 95) return "A";
        if (total >= 90) return "A-";
        if (total >= 85) return "B+";
        if (total >= 80) return "B";
        if (total >= 75) return "B-";
        if (total >= 70) return "C+";
        if (total >= 65) return "C";
        if (total >= 60) return "C-";
        if (total >= 55) return "D+";
        if (total >= 50) return "D";
        return "F";
    }

    @Override
    public String asLine() {
        return String.format("%s | Att1: %.1f | Att2: %.1f | Exam: %.1f | Total: %.1f (%s)",
                course.getName(), att1, att2, finalExam, getTotal(), getLetterGrade());
    }

    @Override
    public String asTable() {
        return String.format("Academic Performance for %s:\nCourse: %s\nFirst Attestation: %.1f\nSecond Attestation: %.1f\nFinal Exam: %.1f\nTotal Score: %.1f Grade: %s\n",
                student.getFirstName(), course.getName(), att1, att2, finalExam, getTotal(), getLetterGrade());
    }
}