package m2j.da.leet75.binary;

/**
 * @see https://leetcode.com/problems/sum-of-two-integers/description/
 * 
 *      Example 1: Input: a = 1, b = 2 Output: 3
 * 
 *      Example 2: Input: a = 2, b = 3 Output: 5
 */
public class _11SumTwoIntegers {
	public static void main(String[] args) {
		System.out.println(getSum(1, 2));

		System.out.println(getSum(2, 3));
	}

	private static int getSum(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}

		return a;
	}

}
