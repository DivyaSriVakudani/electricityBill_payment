package com.oebp.entities;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Connection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long connectionId; 
	
	@NotNull(message= "Consumer no. should not be null")
	@Range(min=1,message="Consumer Number Should Not Be empty")
	private Long consumerNumber;
	
	@NotNull(message= "ApplicationDate should not be null")
	private LocalDate applicationDate;
	
	@NotNull(message= "ConnectionDate should not be null")
	private LocalDate connectionDate;
	
	@NotBlank(message= "Give status as Active or Inactive!!")
	@NotNull(message= "Give status as Active or Inactive!!")
	private String connectionStatus;
	
    private ConnectionType connectionType;
    
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToOne
	private Customer customer;
	
	public Connection() {
		super();
	}
    public Long getConnectionId() {
		return connectionId;
	}
    public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public String getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
	
}
