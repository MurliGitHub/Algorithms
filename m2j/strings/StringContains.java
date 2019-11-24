package m2j.strings;

public class StringContains {
	public static void main(String[] args) {
		String one = "aeaebabsbb";
		String other = "ab";
		
		boolean status = isContains(one, other);
		System.out.println(status);
		
		int isContains = isContainsWithoutLib(other, one);
		System.out.println(isContains);
	}

	private static int isContainsWithoutLib(String s1, String s2) {
		 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1; 
	}
	

	private static boolean isContains(String one, String other) {
		
		boolean isExists = one.indexOf(other) !=-1? true: false; //true
		
		return isExists;
	}

}
