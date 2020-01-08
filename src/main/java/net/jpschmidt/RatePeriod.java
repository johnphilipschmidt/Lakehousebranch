package net.jpschmidt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class RatePeriod {
    private Long id;
    String name;
    LocalDate start;
    LocalDate end;

    protected RatePeriod () {
    }

    protected RatePeriod (Long id, String name, LocalDate start, LocalDate end) {
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

    public LocalDate getStart () {
        return start;
    }

    public void setStart (LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd () {
        return end;
    }

    public void setEnd (LocalDate end) {
        this.end = end;
    }
}
