import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String userId;
    protected String login;
    protected String password;
    protected String name;
    protected Lang lang;

    public User() {
    }

    public User(String userId, String login, String password, String name, Lang lang) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lang = lang;
    }

    public boolean login(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public abstract void viewMenu();

    public void viewNews() {
        System.out.println(name + " is viewing news.");
    }

    public void readPapers() {
        System.out.println(name + " is reading papers.");
    }

    public void submitTechRequest(String desc) {
        System.out.println(name + " submitted tech request: " + desc);
    }

    public void subscribeToJournal(String journalName) {
        System.out.println(name + " subscribed to journal: " + journalName);
    }

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Lang getLang() {
        return lang;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", name: " + name + ", login: " + login;
    }
}