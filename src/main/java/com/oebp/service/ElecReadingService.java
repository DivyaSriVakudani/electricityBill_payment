package com.oebp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.oebp.entities.Bill;
import com.oebp.entities.ElecReading;


public interface ElecReadingService {

	public ElecReading saveElecReading(ElecReading elecreading);

	public List<ElecReading> allElecreading();

	//	public Optional<ElecReading> getElecReadingById(long readingId);

	public ElecReading selfSubmitReading(ElecReading elecreading);

	public boolean deleteElecReading(Long readingId);

	public Optional<ElecReading> getElecReadingById(long readingId) ;

	public ElecReading findMeterReadingByConsumerNumber(Long ConsumerNumber);
	
	//public abstract List<ElecReading> getreadMeterReadingByConsumerNumber(Long consumerNumber);
//public ElecReading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber,LocalDate billDate);
	
}
