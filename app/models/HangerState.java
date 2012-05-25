package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 25.05.12
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class HangerState extends Model {
    @ManyToOne
    public Hanger hanger;

    public Hanger.Status status;

    @ManyToOne(optional = true)
    public Location location;

    public HangerState(Hanger hanger, Hanger.Status status) {
        this.hanger = hanger;
        this.status = status;
    }
}
