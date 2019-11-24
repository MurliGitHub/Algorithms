package m2j.strings;

public class MarsExploration {
	
	// Complete the marsExploration function below.
    static int marsExploration(String s) {
    	
    	int alteredChar = 0;	
    	for (int i = 0; i < s.length(); i++) {
			if((i%3) == 1){
				alteredChar += s.charAt(i) == 'O'? 0:1;
			}else{
				alteredChar += s.charAt(i) == 'S'? 0:1;
			}
		}
		return alteredChar;
    }
	public static void main(String[] args) {
		//String s = "SOSSOSSOS";//0
		//String s = "SOSSOT";//1
		
		String s = "SOSSPSSQSSOR";//3
		int result = marsExploration(s);
		System.out.println(result);
	}
	
	// Complete the marsExploration function below.
    static int marsExplorationBF(String s) {
    	int alteredChar = 0;	
    	for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != 'S' && s.charAt(i) != 'O'){
				alteredChar++;
			}
		}
		return alteredChar;
    }

}
