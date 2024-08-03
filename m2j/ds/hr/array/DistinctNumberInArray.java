package m2j.ds.hr.array;

public class DistinctNumberInArray {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1, 1, 2, 5 };
		System.out.println("Input array is:- ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println(); 
		distict(array);
	}

	private static void distict(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					break;
				}
			}
			
			if(i==j){
				System.out.print(array[i]+" ");
			}
		}
		System.out.println();
	}
}
