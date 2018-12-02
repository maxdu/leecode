package dynamicProgramming;

public class MaxProfit {

	public MaxProfit() {
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));

	}

	public static int maxProfit(int[] prices) {
		// 一次扫描，记录最小价格，和与最小价格产生的最大利润。
		int min = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] - min > maxprofit) {
				maxprofit = prices[i] - min;
			}
		}
		return maxprofit;
	}

	public static int maxProfitSlow(int[] prices) {
		int maxProfit = 0;
		int buyAt = 0;
		int sellAt = 0;
		for (int b = 0; b < prices.length - 1; b++) {
			for (int s = b + 1; s < prices.length; s++) {
				if (maxProfit < prices[s] - prices[b]) {
					buyAt = b;
					sellAt = s;
					maxProfit = prices[s] - prices[b];
				}
			}
		}
		System.out.println(String.format("buy at %s, sell at %s, profit %s", buyAt, sellAt, maxProfit));
		return maxProfit;

	}

}
