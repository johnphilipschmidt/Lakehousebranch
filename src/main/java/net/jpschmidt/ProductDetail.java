package net.jpschmidt;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_detail")
public class ProductDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String madein;
    private float price;


    protected ProductDetail () {
    }

    protected ProductDetail (Long id, String name, String brand, String madein, float price, Product product) {
        super ();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.madein = madein;
        this.price = price;
        this.product = product;
    }


    public Long getId () {
        return id;
    }

    //Define the relationship to product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public String getMadein () {
        return madein;
    }

    public void setMadein (String madein) {
        this.madein = madein;
    }

    public float getPrice () {
        return price;
    }

    public void setPrice (float price) {
        this.price = price;
    }

    public Product getProduct () {
        return product;
    }

    public void setProduct (Product product) {
        this.product = product;
    }
}
