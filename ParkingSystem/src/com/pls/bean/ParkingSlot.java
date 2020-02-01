package com.pls.bean;

public class ParkingSlot implements Comparable<ParkingSlot>
{
	private int slotLaneNo;
	private int price;
	private int nextPrice;
	private boolean flag = true;
	

	public ParkingSlot(int slotLaneNo, int price) 
	{
		super();
		this.slotLaneNo = slotLaneNo;
		this.price = price;
		
		if(slotLaneNo == 204)
		{
			nextPrice=40;
			flag = false;
		}
	}
	
	public boolean getB()
	{
		return flag;
	}
	
	public int getNextPrice() {
		return nextPrice;
	}

	public void setNextPrice(int nextPrice) {
		this.nextPrice = nextPrice;
	}

	public int getSlotLaneNo() 
	{
		return slotLaneNo;
	}

	public void setSlotLaneNo(int slotLaneNo) 
	{
		this.slotLaneNo = slotLaneNo;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	@Override
	public String toString() 
	{
		return "\n\n  ParkingSlot [slotLaneNo=" + slotLaneNo + ", price=" + price + "] \n";
	}

	@Override
	public int compareTo(ParkingSlot slot)
	{
		return this.slotLaneNo-slot.slotLaneNo;
	}
	
	@Override
	public int hashCode() 
	{
		int prime = 31;
		int result = 1;
		result = prime * result + slotLaneNo;
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
		ParkingSlot other = (ParkingSlot) obj;
		if (slotLaneNo != other.slotLaneNo)
			return false;
		return true;
	}
}
