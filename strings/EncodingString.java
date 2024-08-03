package m2j.ds.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EncodingString {
	public static void main(String[] args) {
		String str1 = "I Love Python";
//		String str1 = "Nick Carter stands for an interesting detective story";
//		String str1 = "They walked a short distance in silence";
		String result = calculate_digit_sum_and_replace_spaces(str1);
		System.out.println("The Final Encoded String Is: ");
		System.out.println(result);
	}

	private static String calculate_digit_sum_and_replace_spaces(String str1) {
		
		String input = str1.toLowerCase();
		
		String revresedString = reverseWords(input);
		System.out.println("Revresed String is: " + revresedString);

		String encodedString = letter_to_weight(revresedString);
		System.out.println("Encoded String is: " + encodedString);
		
		int sumOfDigit = sum_of_digit(revresedString);
		System.out.println("sum_of_digit is: " + sumOfDigit);
		
		int countOfDigit = String.valueOf(sumOfDigit).length();
		
		
		String encodedResponse = String.valueOf(countOfDigit)+ encodedString.replaceAll(" ", String.valueOf(sumOfDigit))+ String.valueOf(sumOfDigit);
		
		return encodedResponse;
	}

	private static int sum_of_digit(String str) {
		System.out.println("============Debug sum_of_digit Started===================");
		int sum =0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isLetter(ch)) {
				int weight = ch - 'a' + 1;
				sum += weight;
			} 

		}
		System.out.println("============Debug sum_of_digit Ended==================="+ sum);
		
		return sum;
	}

	private static String letter_to_weight(String str) {

		StringBuilder encoded = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isLetter(ch)) {
				int weight = ch - 'a' + 1;
				
				String weStr =  String.valueOf(weight);
				
				if(weStr.length() == 2) {
					weStr = "0"+weStr+"0";
				}
				
				encoded.append(weStr);
			} else {
				encoded.append(ch);
			}

		}

		return encoded.toString();
	}

	private static String reverseWords8(String input) {
		List<String> list = Arrays.asList(input.split(" "));
		Collections.reverse(list);
		String revresedString = list.stream().collect(Collectors.joining(" "));
		return revresedString;
	}

	private static String reverseWords(String str) {

		String[] words = str.split(" ");

		int n = words.length;

		for (int i = 0; i < n / 2; i++) {

			String w = words[i];
			words[i] = words[n - i - 1];
			words[n - i - 1] = w;

		}

		StringBuilder sb = new StringBuilder();
		for (String str1 : words) {
			sb.append(str1).append(" ");
		}

		return sb.substring(0, sb.length() - 1).toString();
	}

}
