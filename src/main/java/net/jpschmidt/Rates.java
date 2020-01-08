package net.jpschmidt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Rates {
    private Long id;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private double price;

    protected Rates () {
    }


    public Rates (Long id, String name, LocalDate start, LocalDate end, double price) {
        super ();
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId () {
        return id;
    }


    public void setId (Long id) {
        this.id = id;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
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