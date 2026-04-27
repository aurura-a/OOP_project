package university.model;

import university.enums.Grade;

public class Mark {
    private double att1;
    private double att2;
    private double finalExam;

    public Mark(double att1, double att2, double finalExam) {
        this.setAtt1(att1);
        this.setAtt2(att2);
        this.setFinalExam(finalExam);
    }

	public double getAtt1() {
		return att1;
	}

	public void setAtt1(double att1) {
		this.att1 = att1;
	}

	public double getAtt2() {
		return att2;
	}

	public void setAtt2(double att2) {
		this.att2 = att2;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

   

    
}