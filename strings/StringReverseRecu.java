package m2j.ds.string;

import java.util.Scanner;

public class StringReverseRecu {
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		  System.out.println("Enter a string for input:");
	        // String input
	       String str = sc.nextLine();
	       System.out.println("Input String is: "+str);
	       
	       reverseStr(str);
	}

	private static void reverseStr(String str) {

		if(str == null || str.length()<1) {
			System.out.println(str);
		}else {
			
			System.out.print(str.charAt(str.length()-1));
			reverseStr(str.substring(0,str.length()-1));
		} 
		
	}

}
