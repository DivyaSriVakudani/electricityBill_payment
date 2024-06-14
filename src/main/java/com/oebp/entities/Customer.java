package com.oebp.entities;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.Id;
@Component("customer")
@Scope("prototype")
@Entity
public class Customer 
{
    @Id
	@Min(value=1)
	private int customerId;

	@Min(value=12)
	private Long addharNumber;
	 
	@NotBlank
	@Size(min=3,max=10)
	private String firstName;
	 
	private String middleName;
	
	@NotBlank
	@Size(min=3,max=10)
	private String lastName;
	
	private Long mobileNumber;
	 
	@Email
	private String email;
	 
	 
	private String gender;

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, Long addharNumber, String firstName, String middleName, String lastName,
			Long mobileNumber, String email, String gender) {
		super();
		this.customerId = customerId;
		this.addharNumber = addharNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
	}

	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public Long getAddharNumber() {
		return addharNumber;
	}


	public void setAddharNumber(Long addharNumber) {
		this.addharNumber = addharNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
