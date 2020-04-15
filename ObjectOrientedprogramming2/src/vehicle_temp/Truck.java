package vehicle_temp;

import vehicle.Vehicle;

public class Truck extends Vehicle{
	int maxLoadingCapacity;
public Truck() {
	super(100);
}
	public void print() {
		System.out.println("Truck Capacity: "+maxLoadingCapacity);
		System.out.println("Truck color: "+color);
		System.out.println("Truck speed: "+getMaxSpeed());
	}
}
