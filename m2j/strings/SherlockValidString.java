package m2j.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockValidString {

	private final static String isValidNo = "NO";

	private final static String isValid = "YES";
	private final static int CHARS = 26;

	public static boolean sherlockStr(String s) {
		Map<Long, Long> counts = s.chars().mapToObj(t -> (char) t)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.map(Map.Entry::getValue).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		switch (counts.size()) {
		case 1:
			return true;
		case 2:
			Iterator<Long> it = counts.keySet().iterator();
			return (Math.abs(it.next() - it.next()) == 1 && (counts.values().stream().anyMatch(i -> i == 1)));
		default:
			return false;
		}
	}

	static String isValid(String str) {

		int freq[] = new int[CHARS];

		// freq[] : stores the frequency of each
		// character of a string
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}

		for (int i = 0; i < freq.length; i++) {
			System.out.print(freq[i] + " ");
		}
		System.out.println();

		return isValidNo;
	}

	static String isValidJavaMap(String s) {

		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (frequencies.containsKey(c)) {
				frequencies.put(c, frequencies.get(c) + 1);
			} else {
				frequencies.put(c, 1);
			}
		}

		Iterator<Integer> itrValues = frequencies.values().iterator();

		boolean first = true, second = true;
		int val1 = 0, val2 = 0;
		int countOfVal1 = 0, countOfVal2 = 0;

		while (itrValues.hasNext()) {
			int i = itrValues.next();

			if (first) {
				val1 = i;
				first = false;
				countOfVal1++;
				continue;
			}

			if (i == val1) {
				countOfVal1++;
				continue;
			}

			if (second) {
				val2 = i;
				countOfVal2++;
				second = false;
				continue;
			}

			if (i == val2) {
				countOfVal2++;
				continue;
			}

			return isValidNo;
		}

		if (countOfVal1 > 1 && countOfVal2 > 1) {
			return isValidNo;
		} else {
			return isValid;
		}
	}

	// Complete the isValid function below.
	static String isValidByJava(String s) {

		String isValidBlank = "Kuch bhi nai";

		Map<Character, Integer> frequencies = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (frequencies.containsKey(c)) {
				frequencies.put(c, frequencies.get(c) + 1);
			} else {
				frequencies.put(c, 1);
			}
		}

		Set<Integer> freqValuesSet = new HashSet<>();

		for (Integer freq : frequencies.values()) {
			freqValuesSet.add(freq);
		}

		System.out.println("freqValuesSet " + freqValuesSet);

		if (freqValuesSet.size() > 2)
			return isValidNo;
		else if (freqValuesSet.size() == 1)
			return isValid;
		else {// 2 different frequencies
			int f1 = 0;
			int f2 = 0;
			int f1Count = 0;
			int f2Count = 0;
			int i = 0;

			for (int n : freqValuesSet) {
				if (i == 0)
					f1 = n;
				else
					f2 = n;
				i++;
			}

			for (int freq : frequencies.values()) {
				if (freq == f1)
					f1Count++;
				if (freq == f2)
					f2Count++;
			}

			if ((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1))
				return ("YES");
			else if ((Math.abs(f1 - f2) == 1) && (f1Count == 1 || f2Count == 1))
				return ("YES");
			else
				return ("NO");
		}
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		// String s = scanner.nextLine();
		String s = "aaaabbcc";
		String result = isValidByJava(s);

		System.out.println(result);
		// bufferedWriter.write(result);
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		// scanner.close();
	}
}
