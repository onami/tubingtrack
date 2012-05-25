package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 25.05.12
 * Time: 16:37
 *
 * Tubing hanger (подвеска).
 */
@Entity
public class Hanger extends Model {
    public enum Status {
        BAD,
        NEW,
        IN_TRANSIT,
        DELIVERED
    }

    @ManyToOne
    public Location destination;

    @Temporal(value = TemporalType.DATE)
    public Date date;

    @OneToMany(mappedBy = "hanger", cascade = CascadeType.ALL)
    public List<HangerState> states;

    public Integer length;

    public Hanger(Location dest, Integer length) {
        this.destination = dest;
        this.length = length;
    }

    public String toString() {
        return id.toString();
    }
}
