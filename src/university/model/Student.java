public class Student extends User {

    private DegreeType degreeType;
    private double gpa;
    private int totalCredits;
    private Researcher supervisor;
    private String school;
    private String specialization;

    public Student() {
        super();
    }

    public Student(String userId, String login, String password, String name, Lang lang,
                   DegreeType degreeType, double gpa, int totalCredits,
                   String school, String specialization) {
        super(userId, login, password, name, lang);
        this.degreeType = degreeType;
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.school = school;
        this.specialization = specialization;
    }

    @Override
    public void viewMenu() {
        System.out.println("Student menu: view courses, register to course, view transcript, view marks.");
    }

    public void registerToCourse(Course course) {
        System.out.println(name + " registered to course: " + course);
    }

    public void viewTranscript() {
        System.out.println(name + " is viewing transcript.");
    }

    public String getDiplomaTopic() {
        return "Diploma topic is not assigned yet.";
    }

    public Transcript getTranscript() {
        return new Transcript();
    }

    public void joinOrganization() {
        System.out.println(name + " joined a student organization.");
    }

    public void tryPutMark(Student student, Mark mark) throws PermissionDeniedException {
        throw new PermissionDeniedException("Student cannot assign marks.");
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public double getGpa() {
        return gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    public String getSchool() {
        return school;
    }

    public String getSpecialization() {
        return specialization;
    }
}