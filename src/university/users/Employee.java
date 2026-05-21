package university.users;

public abstract class Employee extends User {
    private static final long serialVersionUID = 1L;
    
    protected String department;
    protected double salary; // нужна для инициализации тестов

    public Employee(String id, String firstName, String lastName, String login, String password, String preferredLanguage, String department, double salary) {
        super(id, firstName, lastName, login, password, preferredLanguage);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}
    
