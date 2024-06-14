package com.oebp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oebp.entities.*;
import com.oebp.exceptions.InvalidTransactionException;
import com.oebp.exceptions.PaymentIdNotFoundException;
import com.oebp.repository.PaymentRepository;
@Service("paymentservice")
@Transactional
public class PaymentServiceImpl {
	@Autowired
	PaymentRepository paymentrepository;
	
	
	public PaymentRepository getPaymentrepository() {
		return paymentrepository;
	}
	public void setPaymentrepository(PaymentRepository paymentrepository) {
		this.paymentrepository = paymentrepository;
	}
	public List<Payment> getAllPaymentDetails(){
		List<Payment> list = paymentrepository.findAll();
		return list;
		 
		 
		 
	}
	public Payment updatePayment(Payment payment) {
		if(paymentrepository.existsByPaymentId(payment.getPaymentId()))
			paymentrepository.save(payment);
		return payment;
		
	}
	
	public  Payment addpayment(Payment payment) {
		if(null!= paymentrepository.findByPaymentId(payment.getPaymentId())) {
			paymentrepository.save(payment);
	}
		return payment;
}
	public List<Payment> viewHistoricalPayment(Long paymentId) {
		 return paymentrepository.findByPaymentId(paymentId);
		
	}
	/*public void sendEmailOnPaymentCompletion(Long paymentId) {
		Optional<Payment> op = paymentrepository.findByPaymentId(paymentId);
		if(op.isPresent()) {
			System.out.println("Payment sucesfully completed using"+paymentId+"id");
		}
		else 
			System.out.println("not done with"+paymentId+"id");
	}*/
	public PaymentStatus payBill(Payment payment){
		if(paymentrepository.existsByPaymentId(payment.getPaymentId())) {
			return PaymentStatus.TRUE;
		}
		else 
			throw new InvalidTransactionException("Payment is failed due to Invalid details");
	}
	
	
}
