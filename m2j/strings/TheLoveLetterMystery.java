package m2j.strings;

public class TheLoveLetterMystery {
	// Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
    	int i =0, diff =0;
    	int j = s.length()-1;
    	while(j>i){
    		diff += Math.abs(s.charAt(i)-s.charAt(j));
    		i++;
    		j--;
    	}
		return diff;
    }
	public static void main(String[] args) {
		
		//String s = "abc";//2
		//String s = "abcba";//0
		String s = "abcd";//4
		//String s = "cba";//2
		int result = theLoveLetterMystery(s);
		System.out.println(result);
	}
	
	  static int theLoveLetterMysteryBF(String s) {
	    	if(isPalindrome(s)) return 0;
	    	else{
	    		for (int i = 0; i < s.length(); i++) {
					
				}
	    	}
			return 0;
	    }
	
	static boolean isPalindrome(String str) {

		int n = str.length();
		for (int i = 0; i < n / 2; i++)
			if (str.charAt(i) != str.charAt(n - i - 1))
				return false;
		return true;
	}

}
