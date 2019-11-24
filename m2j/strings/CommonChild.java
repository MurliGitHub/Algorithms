package m2j.strings;

import m2j.utility.CommonUtil;

public class CommonChild {
	// Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int[] charFalg1 = isCharAvailable(s1);
    	CommonUtil.print(charFalg1);
    	
    	int[] charFalg2 = isCharAvailable(s2);
    	
    	CommonUtil.print(charFalg2);
    	int count =0;
    	for(int i =0; i<26;i++){
    		if(charFalg1[i] > 0 && charFalg2[i]>0){
    			count+=Math.min(charFalg1[i], charFalg2[i]);
    		}
    	}
		return count;
    }
    private static int[] isCharAvailable(String s) {
    	int[] uniqueCharFlag = new int[26];
		for (int i = 0; i < s.length(); i++) {
			uniqueCharFlag[s.charAt(i) - 'A']++;
		}
		return uniqueCharFlag;
	}
	public static void main(String[] args) {
    	/*String s1="OUDFRMYMAW";
    	String s2 ="AWHYFCCMQX";
    	//2
*/    	
		String s1="SHINCHAN";
    	String s2 ="NOHARAAA";
    	//3
		int f = findLongestCommonSubsequence(s1, s2);
		System.out.println(f);
	}
	
	private static int findLongestCommonSubsequence(String s1, String s2) {
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
		
		int[][] lcs = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {	
			for (int j = 0; j <= n; j++) {
				
				if(i == 0 || j == 0){
					lcs[i][j] = 0;
				}else if(X[i-1] == Y[j-1]){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = CommonUtil.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		//
		
		
		/*
		   * Print LCS
		   */
		int index = lcs[m][n]; 
        int temp = index; 
        
     // Create a character array to store the lcs string 
        char[] lc = new char[index+1]; 
        lc[index] = ' '; // Set the terminating character 
        
        int i = m, j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (s1.charAt(i-1) == s2.charAt(j-1)) 
            { 
                // Put current character in result 
                lc[index-1] = s1.charAt(i-1);  
                  
                // reduce values of i, j and index 
                i--;  
                j--;  
                index--;      
            } 
   
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if (lcs[i-1][j] > lcs[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        // Print the lcs 
        System.out.print("LCS of "+s1+" and "+s2+" is "); 
        for(int k=0;k<=temp;k++) 
            System.out.print(lc[k]); 
        
        System.out.println();
		
		//
		return lcs[m][n];

	}

    /*private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/

}
