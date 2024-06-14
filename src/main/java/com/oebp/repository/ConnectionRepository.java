package com.oebp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oebp.entities.Connection;
 
@Repository
 public interface ConnectionRepository extends JpaRepository<Connection, Long> {

 	
 	@Query("select c from Connection c where c.consumerNumber=:consumerNumber")
 	public Optional<Connection> existByConsumerNo(@Param(value = "consumerNumber") Long consumerNumber);  
 	
 	@Query("select c from Connection c where c.connectionId=:connectionId")
 	public Connection existById(@Param(value = "connectionId") Long connectionId); 
 	
 	//Optional<Connection> findByConnectionStatus(String  connectionStatus);
    
 	@Query("select c from Connection c JOIN c.address a where a.village = :village AND c.connectionStatus = :connectionStatus")
 	List<Connection> findActiveConnectionByVillage(@Param(value ="village") String villages, @Param(value="connectionStatus") String cStatus);
	
 	@Query("select c from Connection c JOIN c.address a where a.taluka = :taluka AND c.connectionStatus = :connectionStatus")
 	List<Connection> findActiveConnectionByTaluka(@Param(value ="taluka") String talukas , @Param(value ="connectionStatus") String cStatus);
	
 	@Query("select c from Connection c JOIN c.address a where a.district = :district  AND c.connectionStatus = :connectionStatus")
 	List<Connection> findActiveConnectionByDistrict(@Param("district") String districts ,  @Param(value ="connectionStatus") String cStatus);
	
 	@Query("select c from Connection c JOIN c.address a where a.pincode = :pincode   AND c.connectionStatus = :connectionStatus")
 	List<Connection> findActiveConnectionByPincode(@Param("pincode") String pincodes , @Param(value ="connectionStatus") String cStatus);
	
	
 }



