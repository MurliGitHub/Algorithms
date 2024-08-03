package m2j.ds.hr.tree;

import java.util.Arrays;

public class JennysSubtrees {
	static int jennysSubtrees(int n, int r, int[][] edges) {
		
		return -1;
	}

	public static void main(String[] args) {
		int n = 7;
		int r = 1;
		//int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 7 } };
		System.out.println("Input is:::  ");
		Arrays.stream(edges).forEach(a->{
			for (int a1:a) {
				System.out.print(a1+" ");
			}
			System.out.println();
		});
		
		int jennysSubtrees = jennysSubtrees(n, r, edges);
		System.out.println(jennysSubtrees);
	}

}
