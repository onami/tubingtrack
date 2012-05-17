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
    public Reader   reader;   // RFID reader device that was used by the user
    @ManyToOne
    public Location location; // location where session took place
    @Temporal(value = TemporalType.DATE)
    public Date     date;

    public enum Status {
        BAD,
        NEW,
        IN_USE,
        DISPOSED,
        RESTORED
    }

    public Status   status;   // status assigned to the tubing by the operator

    public Session(User user, Reader reader, Location location, Date date, Status status) {
        this.user = user;
        this.reader = reader;
        this.location = location;
        this.date = date;
        this.status = status;
    }

    // state transitions
    // new
    // new -> set up at warehouse, got rid of the tag
    // disposed
    // restored

    // tube can be in of the states:
    //   new tubing, received from the factory (registered in the warehouse)
    //   in use at site (left the warehouse, moved to the drilling room)
    //   taken out of use
    //     needs to reclassified and tagged with new tags
    //        useable,     should be sent to the warehouse? or used immediately?
    //        not useable, should get sent back to the factory

    // state changes are triggered by RFID reader sessions

    // tubing status is stored per-session, not per-tube
    // the rationale being that the tubing will be dealt with in bulk, not on per tube basis

    // the fix to losing tubing identity:
    // when drilling master stops the drilling operation and takes out all the tubing,
    // the tubing that was previously set in use here should be changed to a new state

    // the new state should be called something like 'not available'
    // pretty doable fix, IMO

}
