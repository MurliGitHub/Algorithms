package m2j.strings;

public class TwoChar {
	private static final int NUM_LETTERS = 26;

	public static void main(String[] args) {
		String str = "asdcbsdcagfsdbgdfanfghbsfdabs";
		int length = str.length();

		/* Create arrays representing the 26^2 subproblems */
	    int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
	    int[][] count = new int[NUM_LETTERS][NUM_LETTERS];
	 
	    for (int i = 0; i < length; i++) {
	      char letter = str.charAt(i);
	      int letterNum = letter - 'a';
	 
	      /* Update row */
	      for (int col = 0; col < NUM_LETTERS; col++) {
	        if (pair[letterNum][col] == letter) {
	          count[letterNum][col] = -1;
	        }
	        if (count[letterNum][col] != -1) {
	          pair[letterNum][col] = letter;
	          count[letterNum][col]++;
	        }
	      }
	 
	      /* Update column */
	      for (int row = 0; row < NUM_LETTERS; row++) {
	        if (pair[row][letterNum] == letter) {
	          count[row][letterNum] = -1;
	        }
	        if (count[row][letterNum] != -1) {
	          pair[row][letterNum] = letter;
	          count[row][letterNum]++;
	        }
	      }
	    }
	 
	    /* Find max in "count" array */
	    int max = 0;
	    for (int row = 0; row < NUM_LETTERS; row++) {
	      for (int col = 0; col < NUM_LETTERS; col++) {
	        max = Math.max(max, count[row][col]);
	      }
	    }
	    System.out.println(max);

	}

	private static void twochar() {
		String s = "asdcbsdcagfsdbgdfanfghbsfdabs";
		int maxPattern = 0;

		if (s.length() == 1)// Edge case where length is 1
		{
			System.out.println(maxPattern);
			System.exit(0);
		}

		// Loop through all letter pairs
		for (int i = 0; i < 26; i++) {
			nextLetter: for (int j = i + 1; j < 26; j++) {
				char one = (char) ('a' + i); // First char in pair
				char two = (char) ('a' + j); // Second char in pair
				char lastSeen = '\u0000';
				int patternLength = 0;

				for (char letter : s.toCharArray()) {
					if (letter == one || letter == two) {
						if (letter == lastSeen)// Duplicate found
						{
							continue nextLetter;
						}
						// Not a duplicate
						patternLength++;
						lastSeen = letter;
					}
				} // for char : s

				maxPattern = (patternLength > maxPattern) ? patternLength : maxPattern; // Keep
																						// a
																						// running
																						// max

			} // for j
		} // for i

		System.out.println(maxPattern);
	}

}
