package com.oebp.controller;

import java.util.List;
import javax.validation.Valid;

 

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

 

import com.oebp.entities.Bill;
import com.oebp.entities.ConnectionType;
import com.oebp.repository.BillRepository;
    import com.oebp.service.BillService;
    import com.oebp.exceptions.NoSuchBillException;
    import com.oebp.exceptions.NoSuchBillIdException;
import java.time.LocalDate;

 

    @RestController
    @RequestMapping("/api")
    public class BillController {

 

        @Autowired
        BillService billService;

 

        @GetMapping("/getAllBills")
        private List<Bill> getAllBill() {

 

            return billService.getAllBill();
        }

 

        @GetMapping("/findBillById/{billId}")
        public List<Bill> getbillid(@PathVariable("billId") long billId) throws NoSuchBillIdException {

 

            if (billService.findById(billId).isEmpty()) {
                System.out.println("Bill Not found");
                throw new NoSuchBillIdException("There is no bill with this id to fetch");

 

            }
            System.out.println("Fetched Successfully");
            return billService.findById(billId);
        }
        @PostMapping("/saveOrUpdate")
        public ResponseEntity<Bill> saveOrUpdate(@RequestBody @Valid Bill bill) {
            Bill saveOrUpdate=billService.saveOrUpdate(bill);
            return new ResponseEntity<Bill>(saveOrUpdate,HttpStatus.CREATED);
        }


        @DeleteMapping("/deleteBillById/{billId}") 
        public String deleteBillByid(@RequestBody @PathVariable("billId") Long billId) throws NoSuchBillException
        { 
             billService.deleteBillById(billId);
              return "deleted Successfully";
        }  

        @PutMapping("/editdetailsbyID/{billId}")
        public ResponseEntity<Bill> updateBillById(@PathVariable(value="billId") Long billId,
                @RequestBody  @Valid Bill bill) {
            return new ResponseEntity<Bill>(billService.updateBillById(bill,billId),HttpStatus.OK);
        }
         @GetMapping("/bill/{billDate}")
    public ResponseEntity<Bill>  getBillByBillDate(@PathVariable("billDate" )@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate billDate) {
           return new  ResponseEntity<Bill>(billService.getBillByBillDate(billDate),HttpStatus.FOUND);

      }


        @GetMapping("/bill/billswithindates/stdate/{stDate}/enddate/{endDate}")
        public List<Bill> getbills(@PathVariable("stDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate stDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
              return this.billService.viewBillForDateRange(stDate,endDate);
    }

 @GetMapping("/bill/billbyusingemail/{email}")
 public Bill viewBillByemail(@PathVariable("email") String email) {
	 return billService.viewBillByEmail(email);
	 
 }
 @GetMapping("/bill/billbyusingConsumerNumber/{consumerNumber}")
 public Bill viewBillByconsumernum(@PathVariable("consumerNumber") long consumerNumber) {
	 return billService.viewBillByConsumerNumber(consumerNumber);
	 
 }
 @GetMapping("/bill/billbyusingmobilenumber/{mobileNumber}")
 public Bill viewBillBymobilenum(@PathVariable("mobileNumber") long mobileNumber) {
	 return billService.viewBillByConsumerNumber(mobileNumber);
	 
 }
 @GetMapping("/bill/energybillcalc/connectionType/{connType}/unitsConsumed/{unitsConsumed}")

 public int energyBillCalc(@PathVariable("connType") ConnectionType connType,@PathVariable("unitsConsumed") int unitsConsumed) {

 return this.billService.energyBillCalculator(connType, unitsConsumed);

  

 }

    }

 
