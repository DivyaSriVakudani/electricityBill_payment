package com.oebp.service;

import java.util.List;

import com.oebp.entities.Payment;
import com.oebp.entities.PaymentStatus;


public interface PaymentService{
	PaymentStatus payBill(Payment paid);
	void sendEmailOnPaymentCompletion(Long paymentId);
	List<Payment> viewHistoricalPayment(Long paymentId);
	public List<Payment> getAllPaymentDetails();
	public Payment updatePayment(Payment t);
	public  Payment addpayment(Payment t);
	
	
	//String addPayment(Payment p);

}
