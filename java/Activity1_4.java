package JavaActivity3;

public class Activity1_4 {

	public static void printArr(int[] arr) {
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			String val = (i == arr.length - 1) ? arr[i] + "}" : arr[i] + ", ";
			System.out.print(val);
		}
	}

	public static void insertionSortMethod(int[] arr) {
		int hole;
		for (int i = 1; i < arr.length; i++) {
			int currentElement = arr[i];
			// System.out.println(currentElement);
			hole = i;
			while (hole > 0 && arr[hole - 1] > currentElement) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = currentElement;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 10, 12, 1, 5, 6 };

		System.out.println("Array before sorting: ");
		printArr(arr);

		insertionSortMethod(arr);

		System.out.println("\nArray after sorting: ");
		printArr(arr);
	}

}
