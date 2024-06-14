package com.oebp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oebp.entities.Bill;
import com.oebp.entities.Connection;
import com.oebp.entities.ElecReading;
@Repository
public interface ElecReadingRepository extends JpaRepository<ElecReading,Long>{

	@Query("select e from ElecReading e where e.readingId=:readingId")
	public Optional <ElecReading> existElecReadingId(@Param(value = "readingId") Long readingId);
	
	@Query("select e from ElecReading e where e.connection.consumerNumber=?1")
	public ElecReading findMeterReadingByConsumerNumber( Long consumerNumber);
	
	
	//@Query("SELECT c FROM  Connection c JOIN c.bill b where  c.consumerNumber =:consumerNumber And b.billDate =:billDate")
    // public ElecReading readBillByConsumerNumberAndBillDate(@Param(value="consumerNumber") Long consumerNumber,@Param(value="billDate") LocalDate billDate);
    
}