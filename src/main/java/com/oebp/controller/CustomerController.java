package com.oebp.controller;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oebp.entities.Customer;
import com.oebp.exceptions.DuplicateCustomerException;
import com.oebp.exceptions.NoSuchCustomerException;
import com.oebp.service.CustomerService;




@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/addCustomer")
	public ResponseEntity addCustomer(@Valid @RequestBody Customer customer) throws DuplicateCustomerException {
		try {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		}catch(DuplicateCustomerException ex) {
			HashMap<String, String> map = new HashMap<>();
		    map.put("message", ex.getMessage());

			return  ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(map);
		}
	}



	@GetMapping("/id/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customerId") int customerId) throws NoSuchCustomerException {
		Customer customername = customerService.viewCustomerProfile(customerId);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customername, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCustomer() { 
		return customerService.getAllCustomer();
	}
			@PutMapping("/updateCustomer/{customerId}")
			public Customer updateCustomer(@PathVariable(name = "customerId") int customerId,@RequestBody Customer customer) throws NoSuchCustomerException {
				System.out.println("Controller updateCustomer");
				return customerService.editCustomerProfile(customerId,customer);
			}
    

	@GetMapping("/getbyemail/{email}")
	public Customer getCustomerEmail(@PathVariable String email) throws NoSuchCustomerException {
		return customerService.searchCustomerByEmail(email);
	}
	@GetMapping("/getcustomerbyAddhar/{aadharNumber}")
	public ResponseEntity<Customer> getAddharNumber(@PathVariable(name = "aadharNumber") Long aadharNumber) throws NoSuchCustomerException {
		Customer customername = customerService.searchCustomerByAddhar(aadharNumber); // line
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customername, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getbyname/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName) throws NoSuchCustomerException {
		return customerService.searchCustomerByName(firstName);
	}
	@GetMapping("/getbymobile/{mobileNumber}")
	public Customer getCustomerByMobile(@PathVariable Long mobileNumber) throws NoSuchCustomerException {
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(HttpStatus.OK);
		return (Customer) customerService.searchCustomerByMobile(mobileNumber);


}
}
