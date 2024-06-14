package com.oebp.repository;

 


    import java.util.List;

 


    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

 

import com.oebp.entities.Bill;
import java.util.Optional;
    import java.time.LocalDate;

 


    @Repository("billRepository")
    public interface BillRepository extends CrudRepository<Bill, Long>{

 

        List<Bill> findByBillId(Long billId);
    Optional<Bill> findByBillDate(LocalDate billDate);
        @Query("select b from Bill b where b.billId=:billId")
        public Bill existById(@Param(value = "billId") Long billId); 
        @Query("from Bill b where b.billDate between :stDate and  :endDate")
        public List<Bill> readBillForDateRange( @Param(value="stDate") LocalDate stDate , @Param(value="endDate") LocalDate endDate);

        @Query(value = "SELECT b FROM Bill b WHERE b.elecreading.connection.consumerNumber = ?1")
        public Bill readBillByConsumerNumber(Long consumerNumber);
    

   @Query(value = "SELECT b FROM Bill b WHERE b.elecreading.connection.customer.mobileNumber = ?1")
       public Bill readBillByMobileNumber(Long mobileNumber);
     

        @Query(value = "SELECT b FROM Bill b WHERE b.elecreading.connection.customer.email = ?1")
       public Bill readBillByEmail(String email);

    }