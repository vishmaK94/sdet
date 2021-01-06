package session3;

import java.util.ArrayList;
import java.util.List;

public class Activity3_1 {

	public static void main(String[] args) {

		List<String> myList = new ArrayList<String>();
		
		myList.add("Kelly");
		myList.add("Pam");
		myList.add("Gabe");
		myList.add("Phyllis");
		myList.add("Dwight");
		
		for(String name : myList) {
			System.out.println(name);
		}
		
		System.out.println("Get 3rd name : " + myList.get(2));
		
		if(myList.contains("Roy")) {
			System.out.println("Roy is present");
		} else {
			System.out.println("Roy is not present");
		}
		
		if(myList.contains("Pam")) {
			System.out.println("Pam is present");
		} else {
			System.out.println("Pam is not present");
		}
		
		System.out.println("Size of list : "+myList.size());
		myList.remove("Gabe");
		System.out.println("Updated list: "+myList+"\nSize of list: "+myList.size());
	}

}
