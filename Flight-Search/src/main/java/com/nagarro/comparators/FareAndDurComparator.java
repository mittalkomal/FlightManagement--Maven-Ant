package main.java.com.nagarro.comparators;

import java.util.Comparator;

import main.java.com.nagarro.model.FlightDetails;

public class FareAndDurComparator implements Comparator<FlightDetails> {

	public int compare(FlightDetails m1, FlightDetails m2) {
		if (Integer.parseInt(m1.getFare()) < Integer.parseInt(m2.getFare()))
			return -1;
		if (Integer.parseInt(m1.getFare()) > Integer.parseInt(m2.getFare()))
			return 1;
		else {
			if (Float.parseFloat(m1.getFlightDur()) < Float.parseFloat(m2.getFlightDur()))
				return -1;
			if (Float.parseFloat(m1.getFlightDur()) > Float.parseFloat(m2.getFlightDur()))
				return 1;
			else
				return 0;
		}

	}
}
