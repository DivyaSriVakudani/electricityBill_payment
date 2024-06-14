package com.oebp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.oebp.entities.Address;
import com.oebp.entities.Connection;
import com.oebp.repository.ConnectionRepository;

class ActiveAndInactiveConnectionVillageTest {
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	List<Connection> list;
	ConnectionServiceImpl connRepo;
	@BeforeEach
	public void dummyTestData() {
		Address a =new Address();
		a.setAddressId(103);
    	a.setBuildingName("valli");
    	a.setDistrict("WestGodavari");
    	a.setFlatOrHouseNumber(333);
    	a.setLandmark("Bhimavaram");
    	a.setPincode("534130");
    	a.setState("AndhraPradhesh");
    	a.setTaluka("saripalli");
    	a.setVillage("kommara");
    	Connection c1 =new Connection();
		c1.setConnectionId(1L);
		c1.setConsumerNumber(2222222222L);
		c1.setConnectionStatus("true");
		c1.setAddress(a);
		Address a1 =new Address();
		a1.setAddressId(103);
    	a1.setBuildingName("valli");
    	a1.setDistrict("WestGodavari");
    	a1.setFlatOrHouseNumber(333);
    	a1.setLandmark("Bhimavaram");
    	a1.setPincode("534130");
    	a1.setState("AndhraPradhesh");
    	a1.setTaluka("saripalli");
    	a1.setVillage("kommara");
    	Connection c2 =new Connection();
		c2.setConnectionId(2L);
		c2.setConsumerNumber(2222222222L);
		c2.setConnectionStatus("true");
		c2.setAddress(a1);
		list=new ArrayList<Connection>();
		list.add(c1);
		list.add(c2);
		
		connRepo= new ConnectionServiceImpl();
	}
    @Test
    public void testaddaddressmethod() {
    	Address a= new Address();
    	a.setAddressId(103);
    	a.setBuildingName("valli");
    	a.setDistrict("WestGodavari");
    	a.setFlatOrHouseNumber(333);
    	a.setLandmark("Bhimavaram");
    	a.setPincode("534130");
    	a.setState("AndhraPradhesh");
    	a.setTaluka("saripalli");
    	a.setVillage("kommara");
        Connection cc=new Connection();
        cc.setConnectionId(1L);
        cc.setAddress(a);
        ConnectionRepository  prMock=Mockito.mock(ConnectionRepository.class);
        connRepo.setConnRepo(prMock);
        Mockito.when(prMock.save(cc)).thenReturn(cc);
        Connection actual=connRepo.newConnectionRequest(cc);
        assertTrue(cc.equals(actual));
        Mockito.verify(prMock,Mockito.times(1)).save(cc);
        
        
        
    }
	
	@Test
	public void testfindActiveConnectionVillage() {
	
	List<Connection> c1= new ArrayList<Connection>(list);
	ConnectionRepository  connRepoMock=Mockito.mock(ConnectionRepository.class);
	connRepo.setConnRepo(connRepoMock);
	Mockito.when(connRepoMock.findActiveConnectionByVillage("kommara", "true")).thenReturn(c1);
	List<Connection> actual= connRepo.findActiveConnectionVillage("kommara", "true");
	assertTrue(c1.equals(actual));
	Mockito.verify(connRepoMock,Mockito.times(1)).findActiveConnectionByVillage("kommara", "true");
	}
	
	
}
