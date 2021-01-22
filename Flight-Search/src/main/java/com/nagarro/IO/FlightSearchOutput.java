package main.java.com.nagarro.IO;

import java.util.List;

import main.java.com.nagarro.model.FlightDetails;

public class FlightSearchOutput {

	public void showFilteredData(List<FlightDetails> filteredData) {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s %10s %10s %15s %10s %10s %10s %10s %10s", "Flight No.", "Departure", "Arrival", "Date",
				"Duration", "Fare", "Time", "SeatAvaliable", "Class");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		for (FlightDetails flightList : filteredData) {

			System.out.format("%10s %10s %10s %15s %10s %10s %10s %10s %10s", flightList.getFlightNo(),
					flightList.getDepLoc(), flightList.getArrLoc(), flightList.getValidTill(),
					flightList.getFlightDur(), flightList.getFare(), flightList.getFlightTime(),
					flightList.getSeatAvailibility(), flightList.getFlightClass());
			System.out.println();
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------");
	}

}
