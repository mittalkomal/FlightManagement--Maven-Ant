package main.java.com.nagarro.service;

import java.util.List;
import java.util.Map;

import main.java.com.nagarro.exceptions.NoDataFoundException;
import main.java.com.nagarro.model.FlightDetails;

public interface FlightSearchService {

	/*
	 * Method used to filter flight data according to mentioned filters
	 * 
	 * @param flightData list of flight data
	 * 
	 * @param filters map of filters
	 * 
	 * @returns List<FlightDetails> sortedList after applying filters
	 * 
	 * @throws NoDataFoundException
	 */
	public List<FlightDetails> getFlightDetailsAsFerFilter(List<FlightDetails> flightData, Map<String, String> filter)
			throws NoDataFoundException;

	/*
	 * Method used to sort filtered list depending upon parameters
	 * 
	 * @param flightData list of flight data
	 * 
	 * @param filters map of filters
	 * 
	 */
	public void sortFilteredData(Map<String, String> filter, List<FlightDetails> filteredFlightList);

	/*
	 * Method used to set fares according to parameters
	 * 
	 * @param flightData list of flight data
	 * 
	 * @param filters map of filters
	 * 
	 */
	public void setFareAccordingToFilter(Map<String, String> filter, List<FlightDetails> filteredFlightList);

}
