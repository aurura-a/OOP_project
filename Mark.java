public class Mark {
    private double att1;
    private double att2;
    private double finalExam;

    public Mark(double att1, double att2, double finalExam) {
        this.att1 = att1;
        this.att2 = att2;
        this.finalExam = finalExam;
    }

    public double getTotal() {
        return att1 + att2 + finalExam;
    }

    public Grade getGrade() {
        double total = getTotal();

        if (total >= 90) return Grade.A;
        else if (total >= 75) return Grade.B;
        else if (total >= 60) return Grade.C;
        else if (total >= 50) return Grade.D;
        else return Grade.F;
    }

    public String toString() {
        return "Total: " + getTotal() + " Grade: " + getGrade();
    }
}