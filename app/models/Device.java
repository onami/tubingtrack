package models;

import javax.persistence.*;
import play.db.jpa.Model;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:02
 *
 * RFID reader model.
 */
@Entity
public class Device extends Model {
    //TODO how to we identify readers?

    public String description;

    public Device(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
