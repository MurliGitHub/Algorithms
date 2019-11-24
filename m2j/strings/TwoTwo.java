package m2j.strings;

/**
 * @author M2J
 * @see https://www.hackerrank.com/challenges/two-two/problem
 *
 */
public class TwoTwo {
	
/*	static int twoTwoBF(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j= s.length()-1;
        
        while(i<=j){
        	
        	
        	
        	i++;
        	j--;
        }
        
		return 0;
    }*/
	
	static int strength(String s)
	{
		int count =0;
		char[] a = s.toCharArray();
		int j = s.length();
		
	    if(a[0] == '0'){
	    	return 0;
	    }

	    int indexBp = 0;
	    
	    for (int k = 0; k < j; k++) {
	    	
	    	int v = (int)a[k]-'0';
	    	if(isPowerTwo(v)){
	    		count++;
	    	}else{
	    		indexBp= k;
	    		break;
	    	}
		}
	    if(indexBp>0){
	    	while (0<indexBp) {
		    	int d = (int) Math.pow(10, indexBp);
		    	
				long mod = (Integer.parseInt(s))%(d);
				if(isPowerTwo(mod)){
					count++;
				}
				indexBp--;
			}
	    }else {
	    	if(isPowerTwo(Integer.parseInt(s))){
				count++;
			}
		}
	/*    if(indexBp>0){
	    	for (int i = indexBp; i < j; i++) {
		    	int v = (int)a[i]-'0';
		    	value = value*10 + v;
		    	
		    	System.out.println("Value: "+value);
		    	if(isPowerTwo(value)){
		    		count++;
		    	}
			}
	    }*/
	    
	    int len = j;
	  
	    /*while (0<len) {
	    	int d = (int) Math.pow(10, len-1);
	    	
			long mod = (Integer.parseInt(s))%(d);
			if(isPowerTwo(mod)){
				count++;
			}
			len--;
		}
	       */ 
	    return count;
	}
	public static void main(String[] args) {
		
		/*2222222
		24256
		65536
		023223
		33579*/
		//String s="24256";//4
		//String s= "2222222";//7
	//	String s= "65536";//1
		
		String s="023223";
		
		System.out.println(strength(s));
		
		
	}
	
	static boolean isPowerTwo(long number){
		return (number !=0 && ((number & (number-1))==0));
	}

}
