package models;

import javax.persistence.*;
import play.db.jpa.Model;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:01
 */
@Entity
public class User extends Model {
    public String email;
    public String name;
    public String password;

    public boolean isAdmin;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static User connect(String name, String password) {
        return find("byNameAndPassword", name, password).first();
    }

    public String toString() {
        return email;
    }

}
