package models;

import javax.persistence.*;
import play.db.jpa.Model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Session extends Model {
    @ManyToOne
    public User     user;     // user who started this session
    @ManyToOne
    public Device device;   // RFID reader device that was used by the user
    @ManyToOne
    public Location location; // location where session took place
    @Temporal(value = TemporalType.DATE)
    public Date     date;

    public Session(User user, Device device, Location location, Date date) {
        this.user = user;
        this.device = device;
        this.location = location;
        this.date = date;
    }

}
