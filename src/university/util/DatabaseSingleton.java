package university.util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DatabaseSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static DatabaseSingleton instance;

    private Set<Course> allCourses = new HashSet<>();
    private Set<News> news = new HashSet<>();
    private Set<Request> techRequests = new HashSet<>();

    private Map<String, User> users = new HashMap<>();

    private DatabaseSingleton() {
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getLogin(), user);
    }

    public User authenticate(String login, String password) throws InvalidCredentialsException {
        User user = users.get(login);

        if (user != null && user.login(login, password)) {
            return user;
        }

        throw new InvalidCredentialsException("Invalid login or password.");
    }

    public void saveData() {
        System.out.println("Data saved successfully.");
    }

    public void loadData() {
        System.out.println("Data loaded successfully.");
    }

    public Set<Course> getAllCourses() {
        return allCourses;
    }

    public Set<News> getNews() {
        return news;
    }

    public Set<Request> getTechRequests() {
        return techRequests;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}