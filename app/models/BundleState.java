package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 25.05.12
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class BundleState extends Model {
    @ManyToOne
    public Bundle bundle;

    public Bundle.Status status;
    @Temporal(value = TemporalType.DATE)
    public Date date;

    @ManyToOne(optional = true)
    public Location location;

    public BundleState(Bundle bundle, Bundle.Status status) {
        this.bundle = bundle;
        this.status = status;
    }
}
