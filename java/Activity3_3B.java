package session3;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Activity3_3B {

	public static void main(String[] args) {

		Deque<String> dq = new LinkedList<String>();
		
		dq.add("Giraffe");
		dq.add("Lion");
		dq.add("Puma");
		dq.add("Wolf");
		dq.add("Hyena");
		dq.add("Meerkat");
		
		Iterator<String> animalIterator = dq.iterator();
		
		while(animalIterator.hasNext()) {
			System.out.println(animalIterator.next());
		}
		
		System.out.println("Peeking head element : "+dq.peekFirst());
		System.out.println("Peeking tail element : "+dq.peekLast());
		
		System.out.println("Is Wolf present? : "+dq.contains("Wolf"));
		
		System.out.println("Removing first element : "+dq.pollFirst());
		System.out.println("Updated queue : "+dq);
		
		System.out.println("Removing last element : "+dq.pollLast());
		System.out.println("Updated queue : "+dq);
		
		System.out.println("Pushing element at head : "+dq.offerFirst("Elephant"));
		System.out.println("Updated queue : "+dq);
		
		System.out.println("Pushing element at the tail : "+dq.offerLast("Kangaroo"));
		System.out.println("Updated queue : "+dq);

	}

}
