package university.service;

import java.util.ArrayList;
import university.model.Course; 
import university.exceptions.*;

public class CourseService {
    
    public void addPrerequisite(Course course, String prerequisiteName) {
        course.getPrerequisites().add(prerequisiteName);
    }

    public boolean isFull(Course course) {
        return course.getStudents().size() >= course.getCapacity();
    }

    public void addStudentToCourse(Course course, String studentName, ArrayList<String> completedCourses) 
            throws CourseFullException, PrerequisiteException {

        if (isFull(course)) {
            throw new CourseFullException();
        }

        for (String pre : course.getPrerequisites()) {
            if (!completedCourses.contains(pre)) {
                throw new PrerequisiteException();
            }
        }

        course.getStudents().add(studentName);
    }
}