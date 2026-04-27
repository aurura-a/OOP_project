package university.service;
import university.model.Mark; 
import university.enums.Grade;

public class MarkService {
	public double getTotal(Mark mark) {
	        return mark.getAtt1() + mark.getAtt2() + mark.getFinalExam();
	    }
	public Grade getGrade(Mark mark) {
	        double total = getTotal(mark);

	        if (total >= 90) return Grade.A;
	        else if (total >= 75) return Grade.B;
	        else if (total >= 60) return Grade.C;
	        else if (total >= 50) return Grade.D;
	        else return Grade.F;
	    }
	public String getMarkReport(Mark mark) {
        return "Total: " + getTotal(mark) + " Grade: " + getGrade(mark);
    }

}
