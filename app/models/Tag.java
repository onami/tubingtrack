package models;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;
import play.db.jpa.Model;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Tag extends Model {
    @NaturalId
    public String epc;

    public Tag(String epc) {
        this.epc = epc;
    }
}
