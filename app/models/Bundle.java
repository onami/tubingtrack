package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 25.05.12
 * Time: 16:37
 *
 * Tubing bundle (подвеска).
 */
@Entity
public class Bundle extends Model {
    public enum Status {
        BAD,
        NEW,
        IN_TRANSIT,
        DELIVERED
    }

    @ManyToOne
    public Tag      tag;
    @ManyToOne
    public Location destination;
    public Integer mode; // 0 -- read, 1 -- write

    @OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL)
    public List<BundleState> states = new ArrayList<BundleState>();

    public Integer length;

    public Bundle(Location dest, Integer length) {
        this.destination = dest;
        this.length = length;
    }

    public Bundle(Requisition requisition) {
        this.destination = requisition.destination;
        this.length = requisition.tubesCount * 10; // # of tubes * 10m
    }

    public String toString() {
        return id.toString();
    }
}
