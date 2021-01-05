package JavaActivity2;

public class Activity2 {

	public static void main(String[] args) {

		int[] arr = {10, 77, 10, 54, -11, 10};
		int sum = 0;
		for(int el : arr) {
			if (el==10) sum+=el;
		}
		
		System.out.println("Sum : " + sum);
		
		String result = (sum==30) ? "Value is equal to 30" : "Value is not equal to 30";
		System.out.println(result);
	}

}
