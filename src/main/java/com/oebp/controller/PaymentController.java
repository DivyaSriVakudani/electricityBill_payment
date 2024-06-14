package com.oebp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.oebp.entities.Payment;
import com.oebp.entities.PaymentStatus;
import com.oebp.exceptions.InvalidTransactionException;
import com.oebp.exceptions.PaymentIdNotFoundException;
import com.oebp.service.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class PaymentController {
	@Autowired
	PaymentServiceImpl paymentservice;
	//http://localhost:8099/payment/all
	
	@GetMapping("/payment/all")
	public List<Payment> getAllDetails() {
		 return paymentservice.getAllPaymentDetails();
	}
	//http://localhost:8099/payment/update
	@PutMapping("/payment/update")
    public Payment updatePayment(@RequestBody Payment t)
    {
        return paymentservice.updatePayment(t);
    }

	//http://localhost:8099/payment/addPayment
    @PostMapping("/payment/addPayment")
    @Operation(summary="To add payment details")
    public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment)
    {
        //System.out.println("Hi");
        Payment msg=  paymentservice.addpayment(payment);
        ResponseEntity<Payment> re=new ResponseEntity<Payment>(msg,HttpStatus.CREATED);
        return re;
        
    }
    //http://localhost:8066/readhistoricalpayment/122
    @GetMapping("/readhistoricalpayment/{paymentId}")

    public ResponseEntity<List<Payment>> getListByPaymentId(@PathVariable(name="paymentId")Long paymentId) throws PaymentIdNotFoundException {

     

     

    ResponseEntity<List<Payment>> response = null;

    List<Payment> list = paymentservice.viewHistoricalPayment(paymentId);

     

    response = new ResponseEntity<List<Payment>>(list, HttpStatus.CREATED);

    return response;

    }
    //http://localhost:8099/registerbill
    @PostMapping("payment/registerbill")
    @Operation(summary="To Register Payment status")
    public ResponseEntity<PaymentStatus>  RegisterBill(@Valid @RequestBody Payment payment) throws InvalidTransactionException{
    	
    	System.out.println("payment"+payment);
    	PaymentStatus pay = paymentservice.payBill(payment);
    	
    	ResponseEntity<PaymentStatus> response = new ResponseEntity<PaymentStatus>(pay, HttpStatus.OK);
    	return response;
    }
    
    

}

