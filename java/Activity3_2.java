package session3;

import java.util.HashSet;

public class Activity3_2 {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();

		hs.add("willow");
		hs.add("creak");
		hs.add("rope");
		hs.add("lake");
		hs.add("bridge");
		hs.add("brick");

		System.out.println("Size of hash set : " + hs.size());

		System.out.println(hs.remove("rope"));
		System.out.println(hs.remove("pebble"));

		System.out.println("Is bridge present? : " + hs.contains("bridge"));

		System.out.println("Updated set : " + hs);

	}

}
