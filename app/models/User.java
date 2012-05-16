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
    public String fullname;
    public String password;

    public boolean isAdmin;

    public User(String email, String fullname, String password) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }

    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

    public String toString() {
        return email;
    }

}
