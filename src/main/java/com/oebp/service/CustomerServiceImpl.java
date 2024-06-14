package com.oebp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oebp.entities.Customer;
import com.oebp.exceptions.DuplicateCustomerException;
import com.oebp.exceptions.NoSuchCustomerException;
import com.oebp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo ;
	
	
	@Override
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		if (null != customerRepo.findById(customer.getCustomerId()))
			return customerRepo.save(customer);
		throw new  DuplicateCustomerException ("This customer is already registered");
	}

	@Override
	public Customer viewCustomerProfile(int CustomerId) throws NoSuchCustomerException {
		Optional<Customer> empOpt = customerRepo.findById(CustomerId);
		if (empOpt.isPresent()) {
			return empOpt.get();
		} else {
			throw new NoSuchCustomerException(CustomerId + " this customer is not found.");
		}
	}

	@Override
	public Customer editCustomerProfile(int customerId,Customer customer) throws NoSuchCustomerException {
		//return null;
		if (customerRepo.existsById(customerId)) {
			return customerRepo.save(customer);
		} else {
			throw new NoSuchCustomerException(customer.getCustomerId() + "does not exits");
		}
	}

@Override
public Customer searchCustomerByCustomerId(int customerId) throws NoSuchCustomerException {	
	//return null;
	//return customerRepo.getById(customerId);
	return customerRepo.searchCustomerByCustomerId(customerId);
}

@Override
public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
	//return  ((CustomerService) customerRepo).searchCustomerByEmail(email);
	//return customerRepo.searchCustomerByEmail(email);
	return customerRepo.searchCustomerByEmail(email);
}



@Override
public Customer searchCustomerByMobile(Long mobileNumber) throws NoSuchCustomerException {
	return customerRepo.findByMobileNumber(mobileNumber);
}

@Override
public List<Customer> searchCustomerByName(String firstName) throws NoSuchCustomerException {
	return customerRepo.findByFirstName(firstName);
}

@Override
public Customer searchCustomerByAddhar(Long addharNumber) {
	return customerRepo.searchCustomerByAddharNumber(addharNumber);
}

@Override
public List<Customer> getAllCustomer() {
		System.out.println("Service getAllCustomer");
		return customerRepo.findAll(); 
	}

@Override
public Customer modifyCustomer(Customer customer) throws NoSuchCustomerException  {

	if (customerRepo.existsById(customer.getCustomerId())) {
		return customerRepo.save(customer);
	} else {
		throw new NoSuchCustomerException(customer.getCustomerId() + "does not exits");
	}
}


}