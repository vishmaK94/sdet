package JavaActivity1;

public class Activity1 {

	public static void main(String[] args) {

		Car jaguar = new Car();
		
		jaguar.make = 2014;
		jaguar.color = "Black";
		jaguar.transmission = "Manual";
		
		jaguar.displayCharacteristics();
		jaguar.accelerate();
		jaguar.brake();

	}

}
