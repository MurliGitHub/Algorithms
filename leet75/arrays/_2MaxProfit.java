package m2j.da.leet75.arrays;

/**
 * @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 */
public class _2MaxProfit {
	public static void main(String[] args) {
		
		
//		Example 1:
//
//			Input: prices = [7,1,5,3,6,4]
//			Output: 5
//			Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//			Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
		int[] prices = {7,1,5,3,6,4};
		int priceOutput = maxProfit(prices);
		System.out.println("Example 1 priceOutput: "+priceOutput);
			
//			Example 2:
//
//			Input: prices = [7,6,4,3,1]
//			Output: 0
//			Explanation: In this case, no transactions are done and the max profit = 0.
//
		int[] prices2 = {7,6,4,3,1};
		int priceOutput2 = maxProfit(prices2);
		System.out.println("Example 2 priceOutput: "+priceOutput2);
		
		//[1,2,4,2,5,7,2,4,9,0,9]
		
		int[] prices3 = {1,2,4,2,5,7,2,4,9,0,9};
		int priceOutput3 = maxProfit(prices3);
		System.out.println("Example 3, expected: 9 priceOutput: "+priceOutput3);
	
	}

	public static int maxProfit(int[] prices) {
		
		int b=0, s=1;// b-> buy, s-> sell
		int maxProfit = 0;
		
		
		for (int i = 0; i < prices.length-1; i++) {
			
			if(prices[b]<prices[s]) {
				int profit = prices[s]-prices[b];
				//maxProfit = Math.max(maxProfit, profit);
				maxProfit = (maxProfit > profit) ? maxProfit : profit;
			}else {
				//b++;
				 b=s;
			}
			
			s++;
			
		}
		
		//System.out.println("Min: "+min);
		//System.out.println("max: "+max);
		
		return maxProfit;
	}

}
