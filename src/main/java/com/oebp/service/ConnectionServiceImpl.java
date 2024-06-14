package com.oebp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oebp.entities.Connection;
import com.oebp.exceptions.ConsumerNumberNotFoundException;
import com.oebp.repository.ConnectionRepository;
import com.oebp.service.ConnectionService;


@Service  
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionRepository connRepo;
	public ConnectionRepository getConnRepo() {
		return connRepo;
	}

	public void setConnRepo(ConnectionRepository connRepo) {
		this.connRepo = connRepo;
	}

	@Override
	public Connection newConnectionRequest(Connection newconnection) {

		return connRepo.save(newconnection);
	}
	
	@Override
	public List<Connection> getAllConnection() {
		return connRepo.findAll();
	}
    
	@Override
	public Connection modifyConnection(Connection newConnection, long connectionId) {
         
		Connection connection = connRepo.existById(connectionId);
		if (connection.getConnectionId().equals(connectionId) && connectionId != 0) {
			connRepo.save(newConnection);
			
		}
		return  newConnection;

	}

	@Override
	public Connection searchByConsumerNumber(long consumerNumber) {
	  Optional<Connection> co = connRepo.existByConsumerNo(consumerNumber);
	  if(co.isPresent()) {
		  return co.get();
	  }
	  else {
		   
		  throw new ConsumerNumberNotFoundException("Consumer Number is not found");
	}
}
	
    @Override
    public List<Connection> findActiveConnectionVillage(String village, String connectionStatus){
			return connRepo.findActiveConnectionByVillage(village, connectionStatus);
	}
		
   	@Override
	public List<Connection> findActiveConnectionTaluka(String taluka, String connectionStatus){
			return connRepo.findActiveConnectionByTaluka(taluka, connectionStatus);
	}
		
	@Override
	public List<Connection> findActiveConnectionDistrict(String district, String connectionStatus){
			return connRepo.findActiveConnectionByDistrict(district, connectionStatus);
	}
		
	@Override
	public List<Connection> findActiveConnectionPincode(String pincode, String connectionStatus){
			return connRepo.findActiveConnectionByPincode(pincode, connectionStatus);
	}
		
}
