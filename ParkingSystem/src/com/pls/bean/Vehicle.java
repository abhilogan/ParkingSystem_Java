package com.pls.bean;

public class Vehicle
{

	private int vehicleId;
	private VehicleType vehicleType;
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVehicleId() 
	{
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) 
	{
		this.vehicleId = vehicleId;
	}
	
	public VehicleType getVehicleType() 
	{
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) 
	{
		this.vehicleType = vehicleType;
	}
	
	public Vehicle(int vehicleId, VehicleType vehicleType) 
	{
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		
		if(vehicleType.equals(VehicleType.Bike))
		{
			setPrice(20);
		}
		if(vehicleType.equals(VehicleType.Car))
		{
			setPrice(40);
		}
		if(vehicleType.equals(VehicleType.Truck))
		{
			setPrice(50);
		}
		if(vehicleType.equals(VehicleType.Bus))
		{
			setPrice(60);
		}
	}
	
	@Override
	public String toString() 
	{
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType +", parkingPrice=" + price + "]\n";
	}
	
	@Override
	public int hashCode() 
	{
		int prime = 31;
		int result = 1;
		result = prime * result + vehicleId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Vehicle vehicle = (Vehicle) obj;
		if(vehicleId != vehicle.vehicleId)
			return false;
		
		return true;
	}
		
}
