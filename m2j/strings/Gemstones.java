package m2j.strings;

import java.util.HashSet;
import java.util.Set;

public class Gemstones {
	
	private static int gemstones(String[] arr) {
		return 0;
	}

	public static void main(String[] args) {
		//String[] arr = {"abcdde","baccd","eeabg"};//2 a & b
		//String[] arr = {"abc","abc","bc"};//2 b & c
		String[] arr = {"abc","xzv","mn"};//0
		int result = gemstonesBF(arr);
		System.out.println(result);
	}

	private static int gemstonesBF(String[] arr) {
		
		int size = arr.length;
		Set<Character> set = getSetFromString(arr[0]);
		
		for (int i = 1; i < size; i++) {
			set.retainAll(getSetFromString(arr[i]));
		}
		
		return set.size();
	}

	private static Set<Character> getSetFromString(String str) {
		Set<Character> set = new HashSet<>(); 
		for (char c : str.toCharArray()) {
			set.add(c);
		}
		return set;
	}

}
