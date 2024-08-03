package m2j.ds.hr.queue;

/**
 * @author m2j
 * @see https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 * 
 *
 */
public class CastleGrid {
	static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
		for (String row: grid) {
			char[] cs = row.toCharArray();
			for (char c : cs) {
				
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// ANS -> 3
		String[] grid = { ".X.", ".X.", "..." };
//		.X.
//		.X.
//		...
		int startX = 0, startY = 0, goalX = 0, goalY = 2;
		int moves = minimumMoves(grid, startX, startY, goalX, goalY);
		System.out.println(moves);
	}

}
