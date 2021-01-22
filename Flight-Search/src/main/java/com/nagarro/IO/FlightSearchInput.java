package main.java.com.nagarro.IO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.java.com.nagarro.constants.Constants;
import main.java.com.nagarro.utils.Validations;

public class FlightSearchInput {

	public Map<String, String> takeInput() {
		Map<String, String> inputFilters = new HashMap<String, String>();
		System.out.println("use DEL -Delhi , MUB- Mumbai , BGR- Banglore");
		Scanner sc = new Scanner(System.in);
		inputFilters.put(Constants.DEP_LOC, inputDestination(sc));
		inputFilters.put(Constants.ARR_LOC, inputArrivalLoc(sc));
		inputFilters.put(Constants.FLIGHT_DATE, inputFlightDate(sc));
		inputFilters.put(Constants.FLIGHT_CLASS, inputFlightClass(sc));
		inputFilters.put(Constants.OUTPUT_PREF, inputOutputPreference(sc));
		return inputFilters;

	}

	private String inputDestination(Scanner scInput) {
		Boolean isCorrect = true;
		String dep = "";
		do {
			if (isCorrect == true)
				System.out.println("Please enter Departure Loacation");
			else
				System.err.println(
						"Please enter correct Departure Loacation.use DEL -Delhi , MUB- Mumbai , BGR- Banglore");
			dep = scInput.next();
			isCorrect = Validations.validateLocation(dep);
		} while (isCorrect == false);
		return dep;

	}

	private String inputArrivalLoc(Scanner sc) {
		Boolean isCorrect = true;
		String arrival = "";
		do {
			if (isCorrect == true)
				System.out.println("Please enter Arrival Loacation");
			else
				System.err
						.println("Please enter correct Arrival Loacation.use DEL -Delhi , MUB- Mumbai , BGR- Banglore");
			arrival = sc.next();
			isCorrect = Validations.validateLocation(arrival);
		} while (isCorrect == false);
		return arrival;

	}

	private String inputFlightDate(Scanner scannerInput) {
		System.out.println("Enter date in format dd-MM-YYYY");
		boolean flag = true;
		String date = "";
		do {
			try {
				date = scannerInput.next();
				flag = Validations.validateDate(date);
			} catch (Exception e) {
				System.err.println("Enter date in correct format dd-MM-YYYY");
				flag = false;
				continue;

			}
		} while (flag != true);
		return date;

	}

	private String inputFlightClass(Scanner sc) {
		Boolean isCorrect = true;
		String flightClass = "";
		do {
			if (isCorrect == true)
				System.out.println("Please enter Flight Class E for Economic and B for business");
			else
				System.err.println("Please enter Flight Class E for Economic and B for business");
			flightClass = sc.next();
			isCorrect = Validations.validateFlightClass(flightClass);
		} while (isCorrect == false);
		return flightClass;

	}

	private String inputOutputPreference(Scanner sc) {
		Boolean isCorrect = true;
		String outputPreference = "";
		do {
			if (isCorrect == true)
				System.out.println(
						"Please enter Flight output preference .Enter F for sorting by fare and FD for sorting by fare and duration");
			else
				System.err.println(
						"Please enter Flight output preference .Enter F for sorting by fare and FD for sorting by fare and duration");
			outputPreference = sc.next();
			isCorrect = Validations.validateOutputPref(outputPreference);
		} while (isCorrect == false);
		return outputPreference;
	}

}
