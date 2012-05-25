package models;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;
import play.db.jpa.Model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:05
 *
 * Location RFID tag model.
 */
@Entity
public class Location extends Model {
    public String description;

    public Location(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
