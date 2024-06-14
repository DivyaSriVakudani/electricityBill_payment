
package com.oebp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oebp.entities.Connection;
import com.oebp.entities.ElecReading;
import com.oebp.service.ElecReadingServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController

public class ElecReadingController {

	@Autowired
	private ElecReadingServiceImpl elecReadingServices;

	@GetMapping("/ElecReading")
	@Operation(summary="To get all details of elecReading")
	public ResponseEntity<List<ElecReading>> allElecreading() {
		List<ElecReading> allElecreading=elecReadingServices.allElecreading();
		return new ResponseEntity<List<ElecReading>>(allElecreading,HttpStatus.OK);
	}

	@GetMapping("/ElecReading/{readingId}")
	@Operation(summary="To get details of eleReading by ReadingId")
	public ResponseEntity<Optional<ElecReading>> getElecReadingById(@PathVariable(value="readingId") long readingId)
	{
		return new ResponseEntity<Optional<ElecReading>>(elecReadingServices.getElecReadingById(readingId), HttpStatus.OK);
	}


	@PostMapping("/ElecReading")
	@Operation(summary="To add details of elecReading")
	public ResponseEntity<ElecReading> saveElecReading(@RequestBody @Valid ElecReading elecreading) {
		ElecReading saveElecReading=elecReadingServices.saveElecReading(elecreading);
		return new ResponseEntity<ElecReading>(saveElecReading,HttpStatus.CREATED);
	}

	@PutMapping("/ElecReading/{readingId}")
	@Operation(summary="To update deatls of elcReading by ReadingId")
	public ResponseEntity<ElecReading> addElecReading(@RequestBody @Valid ElecReading elecreading,@PathVariable long readingId) {
		elecreading.setReadingId(readingId);
		ElecReading addElecReading=elecReadingServices.selfSubmitReading(elecreading);
		return new ResponseEntity<ElecReading>(addElecReading,HttpStatus.OK);
	}


	@DeleteMapping("/ElecReading/{readingId}") 
	@Operation(summary="To delete values of elecReading by ReadingId")
	public String deleteElecReading(@PathVariable("readingId") Long readingId) 
	{ 
		elecReadingServices.deleteElecReading(readingId);
		return "deleted Successfully";
	} 
	@GetMapping("/findMeterReadingByConsumerNumber/{consumerNumber}")
	public ElecReading findMeterReadingByConsumerNumber (@PathVariable ("consumerNumber") Long consumerNumber) {
		return  elecReadingServices.findMeterReadingByConsumerNumber(consumerNumber);
		
	}


}