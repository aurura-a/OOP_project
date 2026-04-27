package university.service;

import university.model.*;

public class TeacherService {
	public void putMark(Student student, Course course, Mark mark) {
        System.out.println("Mark added for " + student.getName() + " in " + course.getName());
    }

}
