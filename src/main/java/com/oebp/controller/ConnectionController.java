package com.oebp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oebp.entities.Connection;
import com.oebp.service.ConnectionService;

import io.swagger.v3.oas.annotations.Operation;


  @RestController
  @RequestMapping("/connection")
  public class ConnectionController {
  	
  	@Autowired
  	ConnectionService connectionService;
  	
  

  	@PostMapping("/newConnection")
  	@Operation(summary="To Create newConnection")
  	public ResponseEntity<Connection> newConnectionRequest( @Valid @RequestBody  Connection connection)
  	{
  		return new ResponseEntity<Connection>(connectionService.newConnectionRequest(connection), HttpStatus.CREATED);
  	}
  	
  	@GetMapping("/allConnectionsList")
  	@Operation(summary="To fetch allConnectionList")
 	 public List<Connection> getAllConnection(){
 		return connectionService.getAllConnection();
 	}
 	 
  	@GetMapping("/SearchByConsumerNumber/{consumerNumber}")
  	@Operation(summary="To searchdetails By consumerNumber")
  	public ResponseEntity<Connection> searchByConsumerNumber( @PathVariable(value = "consumerNumber") Long consumerNumber)
  	{
  		return new ResponseEntity<Connection>(connectionService.searchByConsumerNumber(consumerNumber),HttpStatus.OK);
  		
  	}
  	
  	@PutMapping("/ModifyConnection/{connectionId}")
  	@Operation(summary="To modify details by connection ById")
  	public ResponseEntity<Connection> modifyConnection(@PathVariable(value = "connectionId") Long connectionId, @RequestBody Connection newConnection)
  	{
  		return new ResponseEntity<Connection>(connectionService.modifyConnection( newConnection,connectionId), HttpStatus.OK);
  	}
    @GetMapping("/FindConnectionsByVillage/{village}/{connectionStatus}")
    @Operation(summary="To find Active and InActive Connections by village name")
    public  List<Connection>  findActiveByVillage(@PathVariable (value ="village") String village , @PathVariable (value ="connectionStatus") String connectionStatus){
    	return  connectionService.findActiveConnectionVillage(village, connectionStatus);
    }
   
    @GetMapping("/FindConnectionsByTaluka/{taluka}/{connectionStatus}")
    @Operation(summary="To find Active and InActive Connections by Taluka")
    public List<Connection>  findActiveByTaluka(@PathVariable (value ="taluka") String taluka , @PathVariable (value ="connectionStatus") String connectionStatus){
    	return connectionService.findActiveConnectionTaluka(taluka, connectionStatus);
    }
   
    @GetMapping("/FindConnectionsByDistrict/{district}/{connectionStatus}")
    @Operation(summary="To find Active and InActive Connections by District")
    public List<Connection>  findActiveByDistrict(@PathVariable (value ="district") String district, @PathVariable (value ="connectionStatus") String connectionStatus){
    	return connectionService.findActiveConnectionDistrict(district, connectionStatus);
    }
  
  

    @GetMapping("/FindConnectionsByPincode/{pincode}/{connectionStatus}")
    @Operation(summary="To find Active and InActive Connections by pincode")
    public List<Connection>  findActiveByPincode(@PathVariable (value ="pincode") String pincode , @PathVariable (value ="connectionStatus") String connectionStatus){
    	return connectionService.findActiveConnectionPincode(pincode, connectionStatus);
    }
    
  }
  
  
  
 
