package university.service;

import university.model.*;
import java.util.ArrayList;

public class StudentService {
    public void viewMarks(Student student) {
        System.out.println("--- Transcript for " + student.getName() + " ---");
    }

    public boolean registerForCourse(Student student, Course course) {
        if (course.getStudents().size() >= course.getCapacity()) {
            System.out.println("Error: Course is full!");
            return false;
        }
        course.getStudents().add(student.getName());
        return true;
    }
}