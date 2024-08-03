package m2j.ds.hr.array;

public class _2DArray {
	 // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
		}

    	return sum;
    }
	public static void main(String[] args) {
	/*	1 1 1 0 0 0
		0 1 0 0 0 0
		1 1 1 0 0 0
		0 0 2 4 4 0
		0 0 0 2 0 0
		0 0 1 2 4 0*/
		
		int[][] mat= {
				{1, 1, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{0, 0, 2, 4, 4, 0},
				{0, 0, 0, 2, 0, 0},
				{0, 0, 1, 2, 4, 0}	
		};
		
		int hourglassSum = hourglassSumf(mat);
		System.out.println(hourglassSum);
	}
	private static int hourglassSumf(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		for(int i =0 ; i<arr.length-2;i++){
            for(int j =0 ;  j< arr.length-2; j++){
                
                int top = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int middle = arr[i+1][j+1];
                int bottom = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if(top+middle+bottom>sum){
                	sum=top+middle+bottom;
                }
            }
        }
		return sum;
	}


}
