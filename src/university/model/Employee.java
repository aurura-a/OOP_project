package university.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import university.enums.Lang;

public abstract class Employee extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private double salary;

    public Employee(String id, String login, String password, String name,Lang lang, double salary) {
        super(id, login, password, name, lang);
        this.salary = salary;
    }
    public double getSalary() { return salary; }
}

    
