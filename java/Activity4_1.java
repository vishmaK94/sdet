package session4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity4_1 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		Scanner scan = new Scanner(System.in);
				
		System.out.println("How many numbers do you want to enter? : ");
		int numberOfInputs = scan.nextInt();
		
		int i = 1;
		System.out.println("Input number for index 0 : ");
		while(scan.hasNextInt()) {
			System.out.println("Input number for index "+i+" : ");			
			list.add(scan.nextInt());
			i++;
		}
		
		System.out.println("Your array list : "+list);
		System.out.println("Converting array list to array");
		
		Random indexGen = new Random();
		
		int randomIndex = indexGen.nextInt(list.size()-1);
		System.out.println("Randomly generated index : "+randomIndex+"\nNumber at index "+randomIndex+" : "+list.get(randomIndex));
		
		scan.close();
		
	}

}
