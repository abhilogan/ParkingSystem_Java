package com.pls.util;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;
import com.pls.impl.ParkingSystemImpl;

public class Client {

	public static void main(String[] args) throws ParkingFullException, VehicleNotFoundException 
	{
		ParkingSystemImpl impl = new ParkingSystemImpl();
		
		Map<ParkingSlot, List<Vehicle>> map=new HashMap<ParkingSlot, List<Vehicle>>();
		List<Vehicle> list = new ArrayList<Vehicle>();
		map=impl.parkVehicle("Vehicle.txt","ParkingSlot.txt");
		Scanner scanner = new Scanner(System.in);

			int choice = 0;

			do {
				System.out.println(" \n ");
				System.out.println("1 . All ParkingSlot And ParkedVehicles");
				System.out.println("2 . Vehicle in Specfic ParkingLane");
				System.out.println("3 . Find Vehicle ");
				System.out.println("4 . Remove Vehicle ");
				System.out.println("8 . Exit");
				System.out.println("");
				System.out.println("enter condition value");

				choice = scanner.nextInt();

				switch (choice) {

				case 1 :
						System.out.println(map);
						break;

				case 2 : 
						list =impl.getVehicleInLane(map, 201); 
						System.out.println(list);
						break;

				case 3 :
						int parkingLane = impl.locateVehicle(map,1011);
						System.out.println("Parked in ::"+ parkingLane);
						break;
					
				case 4 :
						Vehicle vehicle = impl.removeVehicle(map, 10181);
					    System.out.println(vehicle);
					  
					    for(Entry<ParkingSlot, List<Vehicle>> entry : map.entrySet()) 
					    {
					    	System.out.print(entry.getKey()+ "  SlotSize  ::  "+entry.getValue().size()); 
						}
					    break;

				case 8:
						System.exit(0);
						break;

				default:
						System.out.println("Please enter valid choice..");
						break;

				}

			} while (choice != 8);
		
	}

}