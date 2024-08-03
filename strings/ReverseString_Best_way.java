package m2j.ds.string;

import java.util.Optional;

public class ReverseString_Best_way {
	public static String reverse(String input) {

		// murli -> ilrum

		Optional<String> inpt = Optional.ofNullable(input);

		if (inpt.isPresent()) {
			char[] strArr = input.toCharArray();

			int n = strArr.length;
			for (int j = 0; j < n / 2; j++) {
				char t = strArr[j];
				strArr[j] = strArr[n - j - 1];
				strArr[n - j - 1] = t;
			}

			return new String(strArr);
		}

		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("murli"));
	}
}
