package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 * 
 *
 */
public class BeautifulBinaryString {

	static int beautifulBinaryString(String b) {
		int beautfyStep = 0;
		for (int i = 0; i < b.length() - 1; i++) {
			if (b.charAt(i) == '0' && b.charAt(i + 1) == '1' && b.charAt(i + 2) == '0') {
				beautfyStep++;
				i = i + 2;
			}
		}
		return beautfyStep;

	}

	public static void main(String[] args) {
		// String b = "0100101010";// 3
		// String b ="01100";//0
		String b = "0101010";// 2
		int result = beautifulBinaryString(b);
		System.out.println(result);
	}

	static int beautifulBinaryStringBF(String b) {
		return -1;
	}

}
