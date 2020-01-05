package net.jpschmidt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RatePeriod {
    private Long id;
    String name;
    Date start;
    Date end;

    protected RatePeriod () {
    }

    protected RatePeriod (Long id, String name, Date start, Date end) {
        super ();
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getStart () {
        return start;
    }

    public void setStart (Date start) {
        this.start = start;
    }

    public Date getEnd () {
        return end;
    }

    public void setEnd (Date end) {
        this.end = end;
    }
}
