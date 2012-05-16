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
public class ReadingSession extends Model {
    @ManyToOne
    public User user;       // user who started this session
    @ManyToOne
    public Reader reader;   // RFID reader device that read this tag
    @ManyToOne
    public Location location;
    public Date date;

    public ReadingSession(User user, Reader reader, Location location, Date date) {
        this.user = user;
        this.reader = reader;
        this.location = location;
        this.date = date;
    }
}
