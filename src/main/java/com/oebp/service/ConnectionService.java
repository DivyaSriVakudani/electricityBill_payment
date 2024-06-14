package com.oebp.service;

import java.util.List;

import com.oebp.entities.Connection;

public interface ConnectionService {
	
	Connection  newConnectionRequest(Connection newconnection);
	Connection modifyConnection(Connection newconnection, long conectionId);
    Connection searchByConsumerNumber(long consumerNumber);
	List<Connection> getAllConnection();
    List<Connection> findActiveConnectionVillage(String village, String connectionStatus);
	List<Connection> findActiveConnectionTaluka(String taluka, String connectionStatus);
    List<Connection> findActiveConnectionDistrict(String district, String connectionStatus);
	List<Connection> findActiveConnectionPincode(String pincode, String connectionStatus);
}

