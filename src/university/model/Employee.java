import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Employee extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double salary;
    protected Set<Message> inbox = new HashSet<>();

    public Employee() {
        super();
    }

    public Employee(String userId, String login, String password, String name, Lang lang, double salary) {
        super(userId, login, password, name, lang);
        this.salary = salary;
    }

    public void sendMessage(Employee to, String text) {
        Message message = new Message(this.name, text);
        to.inbox.add(message);
        System.out.println(this.name + " sent message to " + to.getName());
    }

    public void sendComplaint(String text) {
        System.out.println(this.name + " sent complaint: " + text);
    }

    public double getSalary() {
        return salary;
    }

    public Set<Message> getInbox() {
        return inbox;
    }
}