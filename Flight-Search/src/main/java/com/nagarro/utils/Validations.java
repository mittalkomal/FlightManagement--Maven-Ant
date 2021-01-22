package main.java.com.nagarro.utils;

import java.text.SimpleDateFormat;

import main.java.com.nagarro.constants.Constants;

public class Validations {

	public static Boolean validateLocation(String loc) {
		if (loc.equals(Constants.MUB_CODE) || loc.equals(Constants.BGR_CODE) || loc.equals(Constants.DEL_CODE))
			return true;
		else
			return false;
	}

	public static Boolean validateDate(String date) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.dateFormatInCSV);
		dateFormat.parse(date);
		return true;
	}

	public static Boolean validateFlightClass(String flightClass) {
		if (flightClass.equals(Constants.ECONOMIC_PATH) || flightClass.equals(Constants.BUSINESS_CODE))
			return true;
		else
			return false;
	}
	
	public static Boolean validateOutputPref(String outputPref) {
		if (outputPref.equals(Constants.OUTPUT_PREF_FARE) || outputPref.equals(Constants.OUTPUT_PREF_FAREDUR))
			return true;
		else
			return false;
	}

}
