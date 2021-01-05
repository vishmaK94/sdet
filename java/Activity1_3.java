package JavaActivity3;

import java.text.DecimalFormat;

public class Activity1_3 {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("0.00");
		
		double seconds = 1000000000;
		
		double earthSeconds = 31557600;
		double mercurySeconds = 0.2408467;
		double venusSeconds = 0.61519726;
		double marsSeconds = 1.8808158;
		double jupiterSeconds = 11.862615;
		double saturnSeconds = 29.447498;
		double uranusSeconds = 84.016846;
		double neptuneSeconds = 164.79132;
		
		System.out.println("Your age on Earth : "+df.format(seconds/earthSeconds)+" years ");
		System.out.println("Your age on Mercury : "+df.format(seconds*mercurySeconds/earthSeconds)+" years ");
		System.out.println("Your age on Venus : "+df.format(seconds*venusSeconds/earthSeconds)+" years ");
		System.out.println("Your age on Mars : "+df.format(seconds*marsSeconds/earthSeconds)+" years ");
		System.out.println("Your age on Jupiter : "+df.format(seconds*jupiterSeconds/earthSeconds)+" years ");
		System.out.println("Your age on Saturn : "+df.format(seconds*saturnSeconds/earthSeconds)+" years ");
		System.out.println("Your age on Uranus : "+df.format(seconds*uranusSeconds/earthSeconds)+" years ");
		System.out.println("Your age on Neptune : "+df.format(seconds*neptuneSeconds/earthSeconds)+" years ");

	}

}
