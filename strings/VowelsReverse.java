package m2j.ds.string;

import java.util.HashSet;
import java.util.Set;

public class VowelsReverse {
	public static void main(String[] args) {
        String input = "education"; //odicatuen
        String response = reverseVowels(input);
        System.out.println("Input String is "+ input +"\nOutput String is: "+response);

        String input2 = "murli"; //mirlu
        String response2 = reverseVowels(input2);
        System.out.println("Input String is "+ input2 +"\nOutput String is: "+response2);
	}
	
	 public static String reverseVowels(String s) {
	        
	        Set<Character> vowels = new HashSet<>();
	        vowels.add('a');
	        vowels.add('e');
	        vowels.add('i');
	        vowels.add('o');
	        vowels.add('u');
	        vowels.add('A');
	        vowels.add('E');
	        vowels.add('I');
	        vowels.add('O');
	        vowels.add('U');

	        int pivot = 0;

	        StringBuilder inputvowls = new StringBuilder();

	        char[] chars = s.toCharArray();

	        for (int i =0; i< chars.length; i++){
	            if(vowels.contains(chars[i])){
	                pivot++;
	                inputvowls.append(chars[i]);
	            }
	        }


	        for (int i =0; i< chars.length; i++){
	            if(vowels.contains(chars[i])){
	                chars[i] = inputvowls.charAt(--pivot);
	            }
	        }

	        return String.valueOf(chars);
	    }

}
