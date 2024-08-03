package m2j.utility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
	public static void main(String... abc) {
		System.out.println("Murli");

		List<String> list = Arrays.asList("Murli", "Babu", "Atharva-Kushu", "Agastya-Ghanti", "Anjana-Suga", "Advait-Anshu");
		int[] arr = { 5, 2, 3, 12, 3, 5, 6, 7, 2, 111, 0, 8 };
		sort(arr);
		
		Arrays.stream(arr).forEach(v -> System.out.print(v+" "));
		System.out.println();
		
//		List<String> list2 = list.stream().sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList());
		List<String> list2 = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		list2.stream().forEach(v -> System.out.print(v+" "));
		System.out.println();
	}
	
	  static void sort(int[] a) {
	        MDualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);
	    }

}
