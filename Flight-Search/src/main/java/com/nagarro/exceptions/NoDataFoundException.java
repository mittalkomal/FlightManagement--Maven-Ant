package main.java.com.nagarro.exceptions;

public class NoDataFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String reason) {
		super(reason);
	}

}
