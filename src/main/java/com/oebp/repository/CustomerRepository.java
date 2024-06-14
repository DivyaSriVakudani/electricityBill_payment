package com.oebp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oebp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
		public List<Customer> findByFirstName(String firstName);
		public Customer findByMobileNumber(Long mobileNumber);
		public Customer searchCustomerByEmail(String email);
		public Customer searchCustomerByAddharNumber(Long addharNumber);
		public Customer searchCustomerByCustomerId(int customerId);
		
}