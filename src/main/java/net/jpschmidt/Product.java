package net.jpschmidt;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String name;
	private String brand;
	private String madein;
	private float price;


	protected Product () {
	}

	protected Product (Long productId, String name, String brand, String madein, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
		this.productDetails = getProductDetails ();
	}


	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProductDetail> productDetails;


	public Long getProductId () {
		return productId;
	}

	public void setProductId (Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<ProductDetail> getProductDetails () {
		return productDetails;
	}

	public void setProductDetails (Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}
}
