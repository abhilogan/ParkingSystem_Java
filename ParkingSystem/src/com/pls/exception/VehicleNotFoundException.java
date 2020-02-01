package com.pls.exception;

public class VehicleNotFoundException extends Exception{

	@Override
	public String getMessage() {
		System.out.print("Vehicle Is Not Present In Lane \t :: ");
		return super.getMessage();
	}
	
}
