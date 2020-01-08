package net.jpschmidt;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Activity {
	private Long id;
	
	private String name;



	@DateTimeFormat(pattern="MM/dd/yyyy")
	private LocalDate fromDate;

	@DateTimeFormat(pattern="MM/dd/yyyy")
	private LocalDate toDate;
	
	private String location;
	
	private String link;
	
	private String info;
	
	private String costRange;
	
	private int funRating;
	
	private float distanceByCar;
	
	private float distanceByBoat;
	
	private  String notes;
	
	private boolean	enabled;

	protected Activity () {
	}




	protected Activity (Long id,
						String name,
						LocalDate fromDate,
						LocalDate toDate,
						String location,
						String link,
						String info,
						String costRange,
						int funRating,
						float distanceByBoat,
						float distanceByCar,
						String notes,

						boolean enabled
						) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.info = info;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.link = location;
		this.costRange = costRange;
		this.funRating = funRating;
		this.distanceByBoat = distanceByBoat;
		this.distanceByCar = distanceByCar;
		this.enabled = enabled;
		this.notes=notes;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getFromDate() {
//		if(fromDate != null)
//			System.out.println("getFromDate:"+fromDate.toString());
		return fromDate;
	}
	@DateTimeFormat(pattern="MM/dd/yyyy")
	public LocalDate getToDate() {
		return toDate;
	}


	@DateTimeFormat(pattern="MM/dd/yyyy")
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCostRange() {
		return costRange;
	}

	public void setCostRange(String costRange) {
		this.costRange = costRange;
	}

	public int getFunRating() {
		return funRating;
	}

	public void setFunRating(int funRating) {
		this.funRating = funRating;
	}

	public float getDistanceByCar() {
		return distanceByCar;
	}

	public void setDistanceByCar(float distanceByCar) {
		this.distanceByCar = distanceByCar;
	}

	public float getDistanceByBoat() {
		return distanceByBoat;
	}

	public void setDistanceByBoat(float distanceByBoat) {
		this.distanceByBoat = distanceByBoat;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
