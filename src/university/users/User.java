package university.users;

import university.data.SerializableModel;
import java.util.Objects;

public abstract class User extends SerializableModel {
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String preferredLanguage;

    public User(String id, String firstName, String lastName, String login, String password, String preferredLanguage) {
        this.id = id; // Строковый ID вида USR-0001
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.preferredLanguage = preferredLanguage;
        this.email = login + "@university.edu";
    }

    // Геттеры и Сеттеры
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }

    public String getFullname() {
        return firstName + " " + lastName;
    }

    @Override
    public String asLine() {
        return String.format("ID: %s | Role: %s | Name: %s", id, getClass().getSimpleName(), getFullname());
    }

    @Override
    public String asTable() {
        return String.format("User Profile:\nID: %s\nName: %s\nEmail: %s\nLanguage: %s\n", 
                id, getFullname(), email, preferredLanguage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        if (this.id == null || other.id == null) return false;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + ", login=" + login + "]";
    }
}