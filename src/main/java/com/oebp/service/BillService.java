package com.oebp.service;

 


import java.util.List;

 

import com.oebp.entities.Bill;
import com.oebp.entities.ConnectionType;

import java.time.LocalDate;

 


    public interface BillService {

         public List<Bill> getAllBill();   
         public List<Bill> findById(Long billId);
         public Bill saveOrUpdate(Bill bill); 
         public int deleteBillById(Long billId);    
         public Bill updateBillById(Bill bill, Long billId);   
         //public Bill updateBillById(Bill bill);
        public Bill getBillByBillDate(LocalDate billDate);
    public List<Bill> viewBillForDateRange(LocalDate stDate,LocalDate endDate);
    public Bill viewBillByEmail(String email);
    public Bill viewBillByConsumerNumber(Long consumerNumber);
    public void emailBillToCustomer(int customerId,String email );
    public int energyBillCalculator(ConnectionType connType,int unitsConsumed);
    
    }

 