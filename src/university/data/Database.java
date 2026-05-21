package university.data;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import university.users.Student;
import university.users.User;
import university.courses.Course;
import university.courses.CourseSection;
import university.courses.Mark;

public class Database implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Database instance;
    private static final String FILE_PATH = "database.dat";

    private Map<String, User> users;
    private Vector<Course> courses;
    private Vector<Mark> marks;
    private Database() {
        this.users = new HashMap<>();
        this.courses = new Vector<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = loadData();
        }
        return instance;
    }

    public Map<String, User> getUsers() { return users; }
    public Vector<Course> getCourses() { return courses; }
    private Vector<CourseSection> sections = new Vector<>();
    
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(this);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private static Database loadData() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new Database();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Database) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading data (creating new database): " + e.getMessage());
            return new Database();
        }
    }

	public Vector<CourseSection> getSections() {
		if (this.sections == null) {
	        this.sections = new Vector<>();
	    }
	    return this.sections;
	}

	public Vector<Mark> getMarks() {
	    if (this.marks == null) {
	        this.marks = new Vector<>();
	    }
	    return this.marks;
	}

	
}