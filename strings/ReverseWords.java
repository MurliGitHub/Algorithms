package m2j.ds.string;

public class ReverseWords {
	public static void main(String[] args) {
		String S = "i.like.this.program.very.much";
		// Output: much.very.program.this.like.i
		System.out.println(reverseWords(S));

	}

	static String reverseWords(String str) {

		String[] words = str.split("\\.");

		int n = words.length;

		for (int i = 0; i < n / 2; i++) {

			String w = words[i];
			words[i] = words[n - i - 1];
			words[n - i - 1] = w;

		}

		StringBuilder sb = new StringBuilder();
		for (String str1 : words) {
			sb.append(str1).append(".");
		}
		
		
		return sb.substring(0, sb.length() - 1).toString();
	}

}
