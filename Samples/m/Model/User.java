package Model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        boolean res1 = Objects.equals (getPassword (), user.getPassword ());
        boolean res2 = Objects.equals (getUsername (), user.getUsername ());
        return (res1) && (res2);
    }

    @Override
    public String toString() {
        return "username: " + username + "|" + "password: " + password;
    }
}
