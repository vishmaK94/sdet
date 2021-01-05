package session2Activity2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{
	
	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;
	
	public Plane(int maxPassengers) {
		this.maxPassengers = 300;
		this.passengers = new ArrayList<String>();
	}
	
	public void onBoard(String passenger) {
		this.passengers.add(passenger);
	}
	
	public Date takeOff() {
		return new Date();
	}
	
	public void land() {
		this.lastTimeLanded = new Date();
		passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return this.lastTimeLanded;
	}
	
	public List<String> getPassengers(){
		return this.passengers;
	}
}

public class Activity2_2 {

	public static void main(String[] args) {

		Plane plane = new Plane(10);
		
		String[] passengerList = {"Kevin", "Angela", "Oscar", "Meredith", "Creed"};
		
		for(String passenger : passengerList) {
			plane.onBoard(passenger);
		}
		
		System.out.println("Plane took off on : "+plane.takeOff());
		System.out.println("List of passengers onboard: "+plane.getPassengers());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		plane.land();
		System.out.println("Plane landed on : "+plane.getLastTimeLanded());
		
		System.out.println("Passenger list : "+plane.getPassengers());

	}

}
