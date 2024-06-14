package com.oebp.service;
import java.util.List;

import com.oebp.entities.Customer;
import com.oebp.exceptions.DuplicateCustomerException;
import com.oebp.exceptions.NoSuchCustomerException;


public interface CustomerService {
	public Customer addCustomer(Customer customer)throws DuplicateCustomerException;
	
	public Customer viewCustomerProfile(int customerId)throws NoSuchCustomerException;
	
	public Customer searchCustomerByCustomerId(int customerId)throws NoSuchCustomerException;
	
	public Customer searchCustomerByEmail(String email)throws NoSuchCustomerException;
	
	public Customer searchCustomerByAddhar(Long addharNumber)throws NoSuchCustomerException;
	
	public Customer searchCustomerByMobile(Long mobileNumber)throws NoSuchCustomerException;
	
	public List<Customer> searchCustomerByName(String firstName)throws NoSuchCustomerException;
	
	public Customer editCustomerProfile(int customerId,Customer customer) throws NoSuchCustomerException;
	
	public List<Customer> getAllCustomer();
	
	public Customer modifyCustomer(Customer customer) throws NoSuchCustomerException;

}
