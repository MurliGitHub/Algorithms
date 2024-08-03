package m2j.ds.string;

import java.util.LinkedList;
import java.util.List;

/*Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA */

public class PermutationString {
	
	static List<String> list = new LinkedList<String>();

	public static void main(String[] args) {
		String str = "ABCD";
		find_permutaion(str);
		for (String st : list) {
			System.out.print(st+" , ");
		}
		System.out.println();
	}

	private static void find_permutaion(String str) {
		 permute(str, 0, str.length()-1);
	}
	
	private static void permute(String str, int l, int r) 
    { 
		
        if (l == r) {
        	list.add(str);
//            System.out.println(str);
        }
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
        
    }

	private static String swap(String a, int i, int j) {
		char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
	} 
}
