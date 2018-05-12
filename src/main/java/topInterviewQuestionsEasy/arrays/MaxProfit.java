package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1
 * /array/22/
 */
//TODO not finished yet
public class MaxProfit {

	public static void main(String[] args) throws InterruptedException {
		MaxProfit instance = new MaxProfit();

		int data[] = { 7, 1, 5, 3, 6, 4 };
		instance.getMaxProfit(data);

		data = new int[] { 1, 2, 3, 4, 5 };
		instance.getMaxProfit(data);

		data = new int[] { 7, 6, 4, 3, 1 };
		instance.getMaxProfit(data);

	}

	public int getMaxProfit(int[] prices) throws InterruptedException {
		
		if (prices.length == 0)
			return 0;

		int maxProfit = 0;

		// try each plan and get the higher one
		LinkedList<Integer> buy = new LinkedList<>();
		LinkedList<Integer> sell = new LinkedList<>();

		maxProfit = tradeAsFrequentAsPossible(prices, Arrays.stream(prices).average().getAsDouble(), buy, sell);
		showTranscations(prices, buy, sell);

		buy = new LinkedList<>();
		sell = new LinkedList<>();

		maxProfit = tradeAsHigherProfitPerTransAsPossible(prices, buy, sell);
		showTranscations(prices, buy, sell);

		System.out.println();

		return maxProfit;
	}

	private int tradeAsFrequentAsPossible(int[] prices, double avg, Deque<Integer> buy, Deque<Integer> sell) {
		System.out.println(String.format("Try plan A, tradeAsFrequentAsPossible"));
		int ttlBuy = 0, ttlSell = 0;

		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] > avg && (sell.size() == 0 || sell.size() == buy.size())) {
				// sell it if price higher than average price
				sell.offer(i);
			}
			if (prices[i] < avg && sell.size() > buy.size()) {
				// buy for sell
				buy.offer(i);
			}
		}
		if (sell.size() > buy.size()) {
			sell.pollLast();
		}
		for (int b : buy) {
			ttlBuy += prices[b];
		}
		for (int s : sell) {
			ttlSell += prices[s];
		}

		System.out.println(String.format("Total profit is %s", ttlSell - ttlBuy));
		return ttlSell - ttlBuy;

	}

	private int tradeAsHigherProfitPerTransAsPossible(int[] prices, Deque<Integer> buy, Deque<Integer> sell) {
		System.out.println(String.format("Try plan B, tradeAsHigherProfitPerTransAsPossible"));
		int ttlBuy = 0, ttlSell = 0;

		int max = Arrays.stream(prices).max().getAsInt();
		int min = Arrays.stream(prices).min().getAsInt();
		int[] tempArray = prices;

		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] == max && (sell.size() == 0 || sell.size() == buy.size())) {
				// sell it if price is highest
				sell.offer(i);
				// reassign max
				tempArray = Arrays.copyOfRange(tempArray, 0, i - 1);
				max = Arrays.stream(tempArray).max().getAsInt();
			}
			if (prices[i] == min && sell.size() > buy.size()) {
				// buy for sell
				buy.offer(i);
				// reassign max
				tempArray = Arrays.copyOfRange(tempArray, 0, i - 1);
				max = Arrays.stream(tempArray).max().getAsInt();
			}
		}

		System.out.println(String.format("Total profit is %s", ttlSell - ttlBuy));
		return ttlSell - ttlBuy;
	}

	private void showTranscations(int[] prices, List<Integer> buy, List<Integer> sell) {
		for (int i = 0; i < buy.size(); i++) {
			System.out.println(String.format("Buy at day %s, sell at day %s, profit is %s - %s = %s", buy.get(i) + 1,
					sell.get(i) + 1, prices[sell.get(i)], prices[buy.get(i)],
					prices[sell.get(i)] - prices[buy.get(i)]));
		}
	}

}
