package com.pls.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.bean.VehicleType;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public class ParkingSystemImpl implements ParkingSystem {

	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle, String fileParkingSlot) throws ParkingFullException 
	{
		Map<ParkingSlot, List<Vehicle>> map=new TreeMap<ParkingSlot, List<Vehicle>>();
		
		Scanner scanner = null;
		
		try
		{
			scanner=new Scanner(new File(fileParkingSlot));
			
			while(scanner.hasNext())
			{
				String str[]=scanner.nextLine().split(":");
				map.put(new ParkingSlot(Integer.parseInt(str[0].trim()), Integer.parseInt(str[1].trim())),
				new ArrayList<Vehicle>());
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		scanner.close();
		
		List<Vehicle> listVehicles=new ArrayList<Vehicle>();
		
		try
		{
			scanner = new Scanner(new File(fileVehicle));
			
			while(scanner.hasNext())
			{
				String str[]=scanner.nextLine().split("-");
				listVehicles.add(new Vehicle(Integer.parseInt(str[0].trim()),
						VehicleType.valueOf(str[1].trim())));
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		int count = 0;

		for (Vehicle vehicle : listVehicles)
		{
			for (Entry<ParkingSlot, List<Vehicle>> ent : map.entrySet())
			{
				if(vehicle.getPrice()==ent.getKey().getPrice() && ent.getValue().size()<4 && ent.getKey().getB())
				{
					ent.getValue().add(vehicle);
					count++;
					break;
				}
				else	if((vehicle.getPrice()==ent.getKey().getPrice() || vehicle.getPrice()==ent.getKey().getNextPrice())
						&& ent.getValue().size()<4)
				{
					ent.getValue().add(vehicle);
					count++;
					break;
				}
			}
		}

		for (Map.Entry<ParkingSlot, List<Vehicle>> parkingSlot : map.entrySet()) 
		{

			if (parkingSlot.getValue().size() == 4) 
			{
				//System.out.print(parkingSlot.getKey().getSlotLaneNo() + "::::::" + parkingSlot.getKey().getPrice() +" rs ::");
				
				try 
				{
					throw new ParkingFullException();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
		}

		return map;

	}

	@Override
	public List<Vehicle> getVehicleInLane(Map<ParkingSlot, List<Vehicle>> map, int slotLaneNo) 
	{
		List<Vehicle> list = new ArrayList<Vehicle>();

		for (Entry<ParkingSlot, List<Vehicle>> entry : map.entrySet()) 
		{
			if (entry.getKey().getSlotLaneNo() == slotLaneNo)
				return entry.getValue();
		}
		return list;
	}

	@Override
	public int locateVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId) throws VehicleNotFoundException 
	{
		for (Entry<ParkingSlot, List<Vehicle>> entry : map.entrySet()) 
		
		{
			for (Vehicle vehicle : entry.getValue()) 
			{	
				if (vehicle.getVehicleId() == vehicleId) 
				{
					return entry.getKey().getSlotLaneNo();
				}
			}
		}	

		throw new VehicleNotFoundException();

	}

	@Override
	public Vehicle removeVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId) throws VehicleNotFoundException 
	{
		for(Map.Entry<ParkingSlot, List<Vehicle>> entry : map.entrySet())
		{
			ListIterator<Vehicle> iterator = entry.getValue().listIterator();
			
			while(iterator.hasNext())
			{
				Vehicle vehicle = iterator.next();
				
				if(vehicle.getVehicleId() == vehicleId)
				{
					iterator.remove();
					return vehicle;
				}
			}
		}
		return null;
	}

}
