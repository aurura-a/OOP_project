public class Student extends User {
	private double gpa;
    private int totalCredits;

    public Student(String id, String log, String pass, String name) {
        super(id, log, pass, name);
        this.gpa = 0.0;
    }
}