package models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.NaturalId;
import play.db.jpa.Model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:30
 * NOTE: this object is temporal!
 * The temporality relation is defined as follows:
 *   TubeState st1 is said to be recorded later than TubeState st2 iff st1.session.id > st2.session.id
 *
 * TODO: now we need a way to easily find out 'current' state of tubing, preferably without hacks involving writes to some other tables.
 */
@Entity
public class TubeState extends Model {
    @NaturalId
    @ManyToOne(cascade = CascadeType.ALL)
    public Tag  tag;

    @NaturalId
    @ManyToOne
    public Session session;

    public TubeState(Tag tag, Session session) {
        this.tag = tag;
        this.session = session;
    }
}
