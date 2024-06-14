package com.oebp.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ElecReading {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="Reading_Id")
	private Long readingId;
	@Min(0)
	@Column(name="Units_consumed")
	private int unitsConsumed;
	private String readingPhoto;
	@NotNull(message="Reading Date cannot be null")
	private LocalDate readingDate;
	@Min(1)
	@Column(name="Price_Per_Units")
	private int pricePerUnits;
	
	@OneToOne
	private Connection connection;
	//@OneToOne(cascade = CascadeType.ALL)
	//private Bill bill;
	
	
	public Long getReadingId() {
		return readingId;
	}
	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	public String getReadingPhoto() {
		return readingPhoto;
	}
	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}
	public LocalDate getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}
	public int getPricePerUnits() {
		return pricePerUnits;
	}
	public void setPricePerUnits(int pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}
