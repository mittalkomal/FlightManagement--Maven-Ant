package main.java.com.nagarro.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import main.java.com.nagarro.constants.Constants;
import main.java.com.nagarro.model.FlightDetails;

public class CSVReader extends TimerTask {

	ReadWriteLock lock = new ReentrantReadWriteLock();
	private List<String> flightListPath;

	@Override
	public void run() {

		try {
			lock.writeLock().lock();
			List<String> filesPath = getFilesFromFolder();
			lock.writeLock();
			flightListPath = filesPath;
		} finally {
			lock.writeLock().unlock();

		}

	}

	private List<String> getFilesFromFolder() {
		File directoryPath = new File(Constants.CSV_FILE_PATH);
		List<String> filesPath = new ArrayList<String>();
		File files[] = directoryPath.listFiles();
		for (File file : files) {
			filesPath.add(file.getAbsolutePath());
		}
		return filesPath;
	}

	public List<String> getFlightFilesPath() {
		try {
			lock.readLock().lock();
			return flightListPath;
		} finally {
			lock.readLock().unlock();
		}
	}

	@SuppressWarnings("static-access")
	public List<FlightDetails> convertCSVToList() {
		List<String> flightFilePath = getFlightFilesPath();
		while (flightFilePath == null) {
			try {
				Thread.currentThread().sleep(1000);
				flightFilePath = getFlightFilesPath();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String line = "";
		String splitBy = "\\|";
		List<FlightDetails> flightCompleteData = new ArrayList<FlightDetails>();
		for (String filePath : flightFilePath) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				while ((line = br.readLine()) != null) {
					String[] flightDetails = line.split(splitBy);
					if (flightDetails.length > 1) {
						FlightDetails flightData = new FlightDetails();
						flightData.setFlightNo(flightDetails[0]);
						flightData.setDepLoc(flightDetails[1]);
						flightData.setArrLoc(flightDetails[2]);
						flightData.setValidTill(flightDetails[3]);
						flightData.setFlightTime(flightDetails[4]);
						flightData.setFlightDur(flightDetails[5]);
						flightData.setFare(flightDetails[6]);
						flightData.setSeatAvailibility(flightDetails[7]);
						flightData.setFlightClass(flightDetails[8]);
						flightCompleteData.add(flightData);

					}

				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flightCompleteData;

	}

}
