package university.service;

import university.data.Database;
import university.data.IdGenerator;
import university.courses.Course;
import university.courses.Mark;
import university.users.Student;
import university.users.Teacher;

public class CourseService {
    private Database db = Database.getInstance();

    // 1. Регистрация студента на курс (создает оценку автоматически)
    public boolean registerStudentToCourse(Student student, Course course) {
        if (student == null || course == null) return false;
        
        boolean success = student.registerForCourse(course);
        if (success) {
            // Проверяем, нет ли уже ведомости для этой пары студент-курс
            boolean markExists = false;
            for (Mark m : db.getMarks()) {
                if (m.getStudent().equals(student) && m.getCourse().equals(course)) {
                    markExists = true;
                    break;
                }
            }
            // Если ведомости нет — создаем пустую
            if (!markExists) {
                String markId = IdGenerator.generateId("MRK");
                Mark newMark = new Mark(markId, student, course);
                db.getMarks().add(newMark);
            }
        }
        return success;
    }

    // 2. Прикрепление преподавателя к курсу менеджером
    public void assignTeacherToCourse(Teacher teacher, Course course) {
        if (teacher != null && course != null) {
            course.addInstructor(teacher);
        }
    }

    // 3. Выставление или обновление оценки преподавателем
    public boolean gradeStudent(Student student, Course course, double points, int attestationType) {
        for (Mark m : db.getMarks()) {
            if (m.getStudent().equals(student) && m.getCourse().equals(course)) {
                if (attestationType == 1) {
                    m.setAtt1(points);
                } else if (attestationType == 2) {
                    m.setAtt2(points);
                } else if (attestationType == 3) {
                    m.setFinalExam(points);
                }
                return true;
            }
        }
        return false; // Ведомость не найдена
    }
}