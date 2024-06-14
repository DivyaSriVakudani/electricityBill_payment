package com.oebp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oebp.entities.*;

@Repository("paymentrepository")
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	 List<Payment> findByPaymentId(Long id);

	 

	boolean findByPaymentstatus(boolean b);

	boolean existsByPaymentId(Long paymentId);


	
	//@Query("select p from Payment p where p.Bill.ElecReading.connection.consumerNumber= ?1")
	//public Payment readByHistoricalPayment(Long consumerNumber);

	 
	 


}
