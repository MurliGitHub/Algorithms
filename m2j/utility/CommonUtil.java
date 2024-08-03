package m2j.utility;

import java.lang.reflect.Field;
import java.util.List;
import java.util.OptionalInt;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CommonUtil {
	// final static String regex = "^[a-zA-Z0-9]+$";

	private final static String regex = "[^A-Za-z0-9]";

	private CommonUtil() {
		throw new RuntimeException("Are you SERIOUS???");
	}

	static int roundUp(int n) {
		return (n + 4) / 5 * 5;
	}

	public static void main(String[] args) {
		// alphanumericRegex("8474-az");
		swapNumber(2, 20);

		System.out.println(myPow(2, 20));

		System.out.println(capitalise("murLI"));
	}

	public static long myPow(int x, int p) {
		if (p == 0)
			return 1;
		if (p == 1)
			return x;

		long tmp = myPow(x, p / 2);
		System.out.println(tmp);
		if (p % 2 == 0)
			return tmp * tmp;
		else
			return x * tmp * tmp;
	}

	public static void print(int[] array) {
		if (array == null)
			return;

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static String capitalize(String value) {
		if (value == null || value.length() == 0) {
			return value;
		}
		// char init = value.charAt(0);
		// String f = String.valueOf(init).toString().toUpperCase();
		String f = value.substring(0, 1).toUpperCase();
		String othr = value.substring(1).toLowerCase();
		return f.concat(othr);
	}

	public static String capitalise(String str) {

		if (str == null || str.length() == 0) {
			return str;
		}
		int strLen = str.length();
		StringBuffer buffer = new StringBuffer(strLen);
		boolean capitalizeNext = true;
		for (int i = 0; i < strLen; i++) {
			char ch = str.charAt(i);

			if (capitalizeNext) {
				buffer.append(Character.toTitleCase(ch));
				capitalizeNext = false;
			} else {
				buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	public static String capitaliseStrings(String str, char[] delimiters) {
		int delimLen = (delimiters == null ? -1 : delimiters.length);
		if (str == null || str.length() == 0 || delimLen == 0) {
			return str;
		}
		int strLen = str.length();
		StringBuffer buffer = new StringBuffer(strLen);
		boolean capitalizeNext = true;
		for (int i = 0; i < strLen; i++) {
			char ch = str.charAt(i);

			if (isDelimiter(ch, delimiters)) {
				buffer.append(ch);
				capitalizeNext = true;
			} else if (capitalizeNext) {
				buffer.append(Character.toTitleCase(ch));
				capitalizeNext = false;
			} else {
				buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	/**
	 * Is the character a delimiter.
	 *
	 * @param ch         the character to check
	 * @param delimiters the delimiters
	 * @return true if it is a delimiter
	 */
	private static boolean isDelimiter(char ch, char[] delimiters) {
		if (delimiters == null) {
			return Character.isWhitespace(ch);
		}
		for (int i = 0, isize = delimiters.length; i < isize; i++) {
			if (ch == delimiters[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param input as String
	 * @return removed all non number and alphabet
	 */
	public static void alphanumericRegex(String input) {
		input = input.replaceAll(regex, "");
		System.out.println(input);
	}

	/**
	 * @param nums as array of number
	 * @return print all array values.
	 */
	public static void show(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

	}

	public static void swap(int[] nums, int initialIndex, int lastIndex) {

		int temp = nums[initialIndex];
		nums[initialIndex] = nums[lastIndex];
		nums[lastIndex] = temp;
	}

	public static void swapNumber(int number1, int number2) {
		number2 = number1 + number2;
		number1 = number2 - number1;
		number2 = number2 - number1;

		System.out.println("++++++++++++OUTPUT++++++++++++");

		System.out.println("Number1: " + number1);
		System.out.println("Number2: " + number2);
	}

	public static boolean isNonEmptyResponse(Object object) {
		if (object == null)
			return false;

		boolean informationFound = false;

		for (Field f : object.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.get(object) != null) {
					informationFound = true;
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		return informationFound;
	}

	public static void fill(int[] a, int val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static int max(int n1, int n2) {
		return (n1 >= n2) ? n1 : n2;
	}

	public static int min(int n1, int n2) {
		return (n1 <= n2) ? n1 : n2;
	}

	/**
	 * Checks if amount is a negative double number
	 *
	 * @param amount
	 * @return
	 */
	public boolean assertIsNegativeValue(String amount) {
		if (Double.valueOf(amount) < 0) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	public boolean isDouble(String value) {
		boolean result = true;
		try {
			if (value != null) {
				Double.parseDouble(value);
			} else {
				result = false;
			}
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	public boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static String removeCharFromString(String string, char ch) {
		String str = "";

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ch) {
				str += string.charAt(i);
			}
		}

		return str;
	}

	/**
	 * @param s
	 * @return unique Characters from a String
	 */
	public static String uniqueCharsStr(String s) {

		boolean[] count = new boolean[26];
		for (int i = 0; i < s.length(); i++) {

			count[s.charAt(i) - 'a'] = true;
		}

		String uniqueString = "";
		for (int i = 0; i < 26; i++) {
			if (count[i]) {
				char c = (char) (i + 'a');
				uniqueString += c;
			}
		}

		return uniqueString;
	}

	public static int[] charCountInString(String s) {
		int[] charCount = new int[256];
		for (char ch : s.toCharArray()) {
			charCount[ch - 'a']++;
		}
		return charCount;
	}

	public static void print(char[] sCharArray) {
		for (char ch : sCharArray) {
			System.out.print(ch + " ");
		}
		System.out.println();

	}

	public static void print(String[] strArray) {
		if (strArray == null)
			return;
		for (String s : strArray) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

	public static void print(boolean[] charFalg1) {
		for (boolean ch : charFalg1) {
			System.out.print(ch + " ");
		}
		System.out.println();

	}

	public static void print(long[] longArray) {
		for (long lv : longArray) {
			System.out.print(lv + " ");
		}
		System.out.println();

	}

	public static void print(int[][] result) {
		for (int[] res : result) {
			for (int r : res) {
				System.out.print(r + " ");
			}
			System.out.println();
		}

	}

	public static void print(char[][] mat) {
		for (char[] res : mat) {
			for (char r : res) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static int min(List<Integer> list) {
		OptionalInt min = list.stream().mapToInt(v -> v).min();
		return min.getAsInt();
	}

	public static int digit(int num) {
		int count = 0;

		while (num != 0) {
			num /= 10;
			count++;
		}
		return count;
	}

	public static boolean isPow2(int val) {
		return (val & (val - 1)) == 0;
	}
	
	public static void exch(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
