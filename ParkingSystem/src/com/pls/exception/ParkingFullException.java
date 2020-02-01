package com.pls.exception;

public class ParkingFullException extends Exception{

	@Override
	public String getMessage() {
		System.out.print("Parking Full :: ");
		return super.getMessage();
	}

}
