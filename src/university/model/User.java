package university.model;

import java.io.Serializable;
import university.enums.Lang;
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userID ;
    private String login;
    private String password;
    private String name;
    private Lang currentLang;

    public User(String userID, String login, String password, String name, Lang lang) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.name = name;
        this.currentLang = lang; 
    }

    public Lang getCurrentLang() { return currentLang; }
    public void setCurrentLang(Lang currentLang) { this.currentLang = currentLang; }
    public String getUserID() { return userID; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}