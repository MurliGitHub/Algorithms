package m2j.strings;

import m2j.utility.CommonUtil;

public class HighestValuePalindrome {

	static String highestValuePalindrome(String s, int n, int k) {
		
		char[] sCharArray = s.toCharArray();
		
		for (int i = 0,j = n-1; i < j; i++,j--) {
			if(k > 0 && sCharArray[i]!=sCharArray[j]){
				sCharArray[i] = sCharArray[j] = (char)Math.max(sCharArray[i],sCharArray[j]);
				//sCharArray[i] = sCharArray[j] = (char)Math.max('9',Math.max(sCharArray[i],sCharArray[j]));
				k--;
			}
		}
		CommonUtil.print(sCharArray);
		if(k<0) return "-1";
		System.out.println("k::: "+k);
		int m=0;
		int len = sCharArray.length-1;
		while(k > 0 && m<=k/2){
			if(s.charAt(m) == s.charAt(len)){
				sCharArray[m] = sCharArray[len]='9';
			}
			m++;
			k--;
			len--;
		}
		
		String responseStr="";
		for (char ch: sCharArray) {
			responseStr += ch;
		}
		
		boolean palindrom = isPalindrome(responseStr);
		
		if(palindrom) return responseStr;
		else return "-1";
		
		
	}

	private static boolean isPalindrome(String responseStr) {
		int i =0;
		int j = responseStr.length()-1;
		while (i<j) {
			if(responseStr.charAt(i) == responseStr.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		/*
		 * 6 3 092282
		 */
		
		/*("3943", 4, 1); //3993
		("092282", 6, 3); //992299
		("0011", 4, 1); //-1
		("10011", 5, 1); //11011
		("10011", 5, 3); //91019
		("1111911", 7, 4); //9199919
		("329", 3, 2); //999
		("932239", 6, 2); //992299
		("11119111", 8, 4); //91199119
		("11117111", 8, 3); //91177119
		("11117111", 8, 3); //91177119
		("9711319", 7, 4); //9991999
		("1111111", 7, 4); //9911199
		("128392759430124", 15, 8); //929394959493929
*/
		//String response = highestValuePalindrome("1111111", 7, 4);//9911199
//		String response = highestValuePalindrome("128392759430124", 15, 8);//929394959493929
	//	 String response = highestValuePalindrome("092282", 6, 3);//992299
		String response = highestValuePalindrome("3943", 4, 1);// ans-> 3993
		System.out.println("Response::: " + response);

	}

}
