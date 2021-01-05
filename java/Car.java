package JavaActivity1;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		this.tyres = 4;
		this.doors = 4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Car color : "+this.color);
		System.out.println("Car transmission : "+this.transmission);
		System.out.println("Car make : "+this.make);
		System.out.println("Car tyres : "+this.tyres);
		System.out.println("Car doors : "+this.doors);
	}
	
	public void accelerate() {
		System.out.println("Car is moving forward");
	}
	
	public void brake() {
		System.out.println("Car has stopped");
	}

}
