package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 29.05.12
 * Time: 10:01

 • Заявка (на расходные материалы для ремонта)
   ○ Поступает на Склад согласно графику планового ремонта
   ○ Является основанием для Кладовщика собирать Подвеску
   ○ Содержит:
     § номер скважины (откуда поступила, или точнее, куда отправить ценности со Склада)
     § дата создания (FIXME: или же дата поступления на склад???)
     § количество труб
     § количество насосных штанг
     § насос (FIXME: тип, вид насоса?)
 */
@Entity
public class Requisition extends Model {
    @ManyToOne
    public Location destination;
    @Temporal(value = TemporalType.DATE)
    public Date creationDate;

    public Integer tubesCount;
    public Integer pumpRodsCount;
    // TODO pump?

    public Requisition(Location destination, Date creationDate, Integer tubesCount, Integer pumpRodsCount) {
        this.destination = destination;
        this.creationDate = creationDate;
        this.tubesCount = tubesCount;
        this.pumpRodsCount = pumpRodsCount;
    }
}
