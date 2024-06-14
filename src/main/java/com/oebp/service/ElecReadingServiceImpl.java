package com.oebp.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oebp.entities.Connection;
import com.oebp.entities.ElecReading;
import com.oebp.exceptions.NoSuchReadingException;
import com.oebp.repository.ConnectionRepository;
import com.oebp.repository.ElecReadingRepository;

@Service
public class ElecReadingServiceImpl implements ElecReadingService {

	@Autowired
	private ElecReadingRepository elecreadingRepository;
	public ElecReading addElecReading; 
	

	public ElecReadingRepository getElecreadingRepository() {
		return elecreadingRepository;
	}

	public void setElecreadingRepository(ElecReadingRepository elecreadingRepository) {
		this.elecreadingRepository = elecreadingRepository;
	}

	@Override
	public ElecReading saveElecReading(ElecReading elecreading) {

		return elecreadingRepository.save(elecreading);
	}

	@Override
	public List<ElecReading> allElecreading() {
		return elecreadingRepository.findAll();
	}

	@Override
	public ElecReading selfSubmitReading(ElecReading elecreading) {
		return elecreadingRepository.save(elecreading);
	}

	
	@Override
	public Optional<ElecReading> getElecReadingById(long readingId)  {
		Optional<ElecReading> elecreading = elecreadingRepository.existElecReadingId(readingId);
		return elecreading;
	}


	@Override
	public boolean deleteElecReading(Long readingId) throws NoSuchReadingException {
		if (elecreadingRepository.existsById(readingId)) {

			elecreadingRepository.deleteById(readingId);
			return false;
		} 
		else {
			throw new NoSuchReadingException("No such reading to delete");
		}
	}

	/*@Override
	public ElecReading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate) {
		// TODO Auto-generated method stub
		ElecReading eler = elecreadingRepository.readBillByConsumerNumberAndBillDate(consumerNumber,billDate);
	    return eler;
	}*/
	@Override
	public ElecReading findMeterReadingByConsumerNumber(Long consumerNumber) {
		ElecReading ob = elecreadingRepository.findMeterReadingByConsumerNumber(consumerNumber);
		return ob;
	}
}
	

