package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 * 
 *
 */
public class HackerRank_in_a_String {
	
	static String hackerrankInString(String s) {
		char[] toFindChar = {'h','a','c','k','e','r','r','a','n','k'};
		int index = 0;
		for (char inputChar : s.toCharArray()) {
			if(toFindChar[index] == inputChar){
				index++;
			}
			
			if(index == toFindChar.length) return "YES";
		}
		return "NO";
    }

	public static void main(String[] args) {
//		String s = "hereiamstackerrank"; //YES
	//	String s = "hackerworld"; //NO
		String s = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"; //NO
		//String s = "haacckkerrannkk"; //YES
		//String s = "haacckkerannk"; //NO
		
		String result = hackerrankInString(s);
		System.out.println(result);

	}
	
	static String hackerrankInStringBF(String s) {
		return null;
    }

}
