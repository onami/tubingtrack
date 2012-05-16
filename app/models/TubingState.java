package models;

import play.db.jpa.Model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class TubingState extends Model {
    public int history;
    @OneToOne
    public Tag tag;         // the tag this information refers to
    @ManyToOne
    public ReadingSession session;

    public enum Status {
        BAD,
        NEW,
        DISPOSED,
        RESTORED
    }

    public Status status;

    public TubingState(int history, Tag tag, ReadingSession session, Status status) {
        this.history = history;
        this.tag = tag;
        this.session = session;
        this.status = status;
    }
}
