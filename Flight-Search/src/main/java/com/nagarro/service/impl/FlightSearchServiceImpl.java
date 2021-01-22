package main.java.com.nagarro.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import main.java.com.nagarro.comparators.FareAndDurComparator;
import main.java.com.nagarro.comparators.FareComparator;
import main.java.com.nagarro.constants.Constants;
import main.java.com.nagarro.exceptions.NoDataFoundException;
import main.java.com.nagarro.model.FlightDetails;
import main.java.com.nagarro.service.FlightSearchService;

public class FlightSearchServiceImpl implements FlightSearchService {

	@Override
	public List<FlightDetails> getFlightDetailsAsFerFilter(List<FlightDetails> flightData, Map<String, String> filter)
			throws NoDataFoundException {
		List<FlightDetails> filteredFlightList = new ArrayList<>();

		for (FlightDetails data : flightData) {
			if (data.getArrLoc().equals(filter.get(Constants.ARR_LOC))
					&& data.getDepLoc().equals(filter.get(Constants.DEP_LOC))
					&& data.getFlightClass().contains(filter.get(Constants.FLIGHT_CLASS))
					&& data.getSeatAvailibility().equals("Y")) {
				filteredFlightList.add(data);
			}
		}
		if (filteredFlightList.size() > 0) {
			setFareAccordingToFilter(filter, filteredFlightList);
			sortFilteredData(filter, filteredFlightList);
		} else {
			throw new NoDataFoundException("No data found for given arrival/destination location");
		}
		return filteredFlightList;
	}

	@Override
	public void sortFilteredData(Map<String, String> filter, List<FlightDetails> filteredFlightList) {
		if (filter.get(Constants.OUTPUT_PREF).equals("F")) {
			Collections.sort(filteredFlightList, new FareComparator());
		} else {
			Collections.sort(filteredFlightList, new FareAndDurComparator());
		}
	}

	@Override
	public void setFareAccordingToFilter(Map<String, String> filter, List<FlightDetails> filteredFlightList) {
		for (FlightDetails list : filteredFlightList) {
			if (filter.get(Constants.FLIGHT_CLASS).equals("B")) {
				int increasedFare = (Integer.parseInt(list.getFare()) * Constants.FARE_INCREASE_PERCENTAGE) / 100
						+ Integer.parseInt(list.getFare());
				list.setFare(Integer.toString(increasedFare));
			}
		}
	}

}
