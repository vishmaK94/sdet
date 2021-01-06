package session3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3A {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<6; i++) {
			q.add(i);
		}
		
		System.out.println("Original queue : "+q);
		
		System.out.println("Removing number with remove() method");
		System.out.println(q.remove());
		System.out.println("Updated queue : "+q);
		System.out.println("Size of queue : "+q.size());
		System.out.println("Adding a number : 33");
		System.out.println(q.add(33));
		System.out.println("Updated queue : "+q);
		System.out.println(q.peek());
		System.out.println("Size of queue : "+q.size());
		System.out.println("Updated queue : "+q);

	}

}
