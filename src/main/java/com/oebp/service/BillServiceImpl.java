package com.oebp.service;

 

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

 

    
    import java.time.LocalDate;
    import com.oebp.entities.Bill;
import com.oebp.entities.ConnectionType;
import com.oebp.exceptions.BillNotFoundByBillDateException;
import com.oebp.exceptions.NoSuchBillException;
import com.oebp.repository.BillRepository;

 

    @Service("billService")
    public class BillServiceImpl implements BillService {

 

        @Autowired
        BillRepository billRepository;

 

        public BillRepository getBillRepository() {
            return billRepository;
        }

 

        public void setBillRepository(BillRepository billRepository) {
            this.billRepository = billRepository;
        }

 

        @Override
        public List<Bill> getAllBill() {

            List<Bill> bills = new ArrayList<Bill>();
            billRepository.findAll().forEach(bill -> bills.add(bill));
            return bills;
        }

 

        @Override
        public List<Bill> findById(Long billId) {
            if(billId == null)
            {
                System.out.println("BillId is null");        }
            return (List<Bill>) billRepository.findByBillId(billId);
        }

 

        @Override
        public Bill saveOrUpdate(Bill bill) {

            return billRepository.save(bill);
        }

 

        @Override
        public int deleteBillById(Long billId)  {

            if (billRepository.existsById(billId)) {

 

                billRepository.deleteById(billId);
                return 1;
            } else {
                throw new NoSuchBillException("There is no bill with this id to delete");
            }
        }

 

        @Override
        public Bill updateBillById(Bill bill, Long billId) {

            Bill bills = billRepository.existById(billId);

 

            if (bills.getBillId().equals(billId)) {
                billRepository.save(bill);
            }
            return bill;
        }    


        @Override
        public Bill getBillByBillDate(LocalDate billDate)  {
              Optional<Bill> op=billRepository.findByBillDate(billDate);
                 if(op.isPresent()) {
                     return op.get();
                 }
                 else {

                      throw new BillNotFoundByBillDateException("billdate is not correct");
                 }
        }


         public List<Bill> viewBillForDateRange(LocalDate stDate,LocalDate endDate) {

        List<Bill> Bills=billRepository.readBillForDateRange(stDate,endDate);
        return Bills;
        }
         
        public Bill viewBillByEmail(String email) {  
          Bill billopt = billRepository.readBillByEmail(email);
        	  return billopt;
       }
        	         public Bill viewBillByConsumerNumber(Long consumerNumber) {  
     	        	    Bill billopt = billRepository.readBillByConsumerNumber(consumerNumber);
     	        	    return billopt;
     	         }



        	         public Bill viewBillByMobileNumber(Long consumerNumber) {  
      	        	    Bill billopt = billRepository.readBillByConsumerNumber(consumerNumber);
      	        	    return billopt;
      	         }	
     	         
        	         public void emailBillToCustomer(int customerId,String email ) {
        	        	 System.out.println(email+" is sent to following customerId "+customerId);
        	         }

        	         
        	         
        	         public int energyBillCalculator(ConnectionType connType,int unitsConsumed) {

        	        	 

        	        	 

        	        	 int calculatedBill = 0;

        	        	  

        	        	 switch(connType) {

        	        	 case NON_INDUSTRIAL :

        	        	 if(unitsConsumed<20) {

        	        	 calculatedBill =100;

        	        	 break;

        	        	 }

        	        	 calculatedBill = 5 * unitsConsumed;

        	        	 break;

        	        	  

        	        	 case INDUSTRIAL :

        	        	 if(unitsConsumed<1000) {

        	        	 calculatedBill =15000;

        	        	 break;

        	        	 }

        	        	  

        	        	 calculatedBill = 15 * unitsConsumed;

        	        	 break;

        	        	  

        	        	 case AGRICULTURAL :

        	        	 if(unitsConsumed<20) {

        	        	 calculatedBill =60;

        	        	 break;

        	        	 }

        	        	 calculatedBill = 3 * unitsConsumed;

        	        	  

        	        	 }

        	        	 //System.out.println(calculatedBill);

        	        	 return calculatedBill;

        	        	  

        	        	 }

        	        	  
}