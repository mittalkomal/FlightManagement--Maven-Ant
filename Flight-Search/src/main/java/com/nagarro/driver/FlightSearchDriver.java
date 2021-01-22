package main.java.com.nagarro.driver;

import java.util.List;
import java.util.Map;
import java.util.Timer;

import main.java.com.nagarro.IO.FlightSearchInput;
import main.java.com.nagarro.IO.FlightSearchOutput;
import main.java.com.nagarro.exceptions.NoDataFoundException;
import main.java.com.nagarro.model.FlightDetails;
import main.java.com.nagarro.service.FlightSearchService;
import main.java.com.nagarro.service.impl.FlightSearchServiceImpl;
import main.java.com.nagarro.utils.CSVReader;

public class FlightSearchDriver {

	public static void main(String[] args) {

		try {
			// initiate Thread
			Timer flightTimer = new Timer();
			CSVReader filesPath = new CSVReader();
			flightTimer.schedule(filesPath, 0, 120000);

			// input
			FlightSearchInput flightSearchInput = new FlightSearchInput();
			Map<String, String> filter = flightSearchInput.takeInput();

			// getData
			List<FlightDetails> flightData = filesPath.convertCSVToList();

			// Manipulate Data
			FlightSearchService flightService = new FlightSearchServiceImpl();
			List<FlightDetails> filteredData = flightService.getFlightDetailsAsFerFilter(flightData, filter);

			//output
			FlightSearchOutput flightSearchOutput = new FlightSearchOutput();
			flightSearchOutput.showFilteredData(filteredData);

		} catch (NoDataFoundException e) {
			System.err.println(e.getMessage()+" Please try again");

		} catch (Exception e) {
            System.err.println("Some unknown exception has occured. Please check your data and try again");
		}

	}

}
