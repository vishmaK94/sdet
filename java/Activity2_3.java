package session2Activity2;

interface BicycleParts {

	public static final int gears = 0;
	public static final int speed = 0;
}

interface BicycleOperations {

	public void applyBrake(int decrement);

	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {

	protected int gears;
	protected int currentSpeed;

	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		this.currentSpeed -= decrement;
	}

	@Override
	public void speedUp(int increment) {
		this.currentSpeed += increment;
	}

	public void bicycleDesc() {
		System.out.println(
				"Number of gears of bicycle : " + this.gears + "\nCurrent speed of bicycle : " + this.currentSpeed);
	}

}

class MountainBike extends Bicycle {

	private int seatHeight;

	public MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}

	public void setHeight(int newSeatHeight) {
		this.seatHeight = newSeatHeight;
	}

	@Override
	public void bicycleDesc() {
		System.out.println("Number of gears of bicycle : " + this.gears + "\nCurrent speed of bicycle : "
				+ this.currentSpeed + "\nSeat height of bicycle : " + this.seatHeight);
	}
}

public class Activity2_3 {

	public static void main(String[] args) {
		
		MountainBike mountainBike = new MountainBike(4, 10, 4);
		
		mountainBike.bicycleDesc();
		System.out.println("Increasing speed");
		mountainBike.speedUp(5);
		
		mountainBike.bicycleDesc();
		System.out.println("Applying brakes");
		mountainBike.applyBrake(2);
		
		mountainBike.bicycleDesc();
		System.out.println("Resetting seat height");
		mountainBike.setHeight(3);
		
		mountainBike.bicycleDesc();	

	}

}
