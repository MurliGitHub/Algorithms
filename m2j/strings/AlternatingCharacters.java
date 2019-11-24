package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/alternating-characters/problem
 * 
 *
 */
public class AlternatingCharacters {
	private static int alternatingCharacters(String s) {
		int k = 0;
		int count=0;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(k)){
				count++;
			}
			k++;
		}
		return count;
	}

	public static void main(String[] args) {
		//String s = "AAAA";
		// String s = "BBBBB";
		//String s = "ABABABAB";
		//String s = "BABABA";
		 String s = "AAABBB";
		int result = alternatingCharacters(s);
		System.out.println(result);

	}

	@SuppressWarnings("unused")
	private static int alternatingCharactersJava(String s) {
		//Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			//set.add(s.charAt(i));
		}

		return 0;
	}

}
