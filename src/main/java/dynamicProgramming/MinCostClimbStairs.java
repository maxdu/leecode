package dynamicProgramming;

public class MinCostClimbStairs {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

	}

	// https://www.jianshu.com/p/bd6b834d2546
	public static int minCostClimbingStairs(int[] cost) {
		// 解 https://blog.csdn.net/ygtrece/article/details/78876958
		int length = cost.length;
		if (length == 0)
			return 0;
		int[][] sum = new int[length][2];
		sum[0][0] = 0;
		sum[0][1] = cost[0];
		for (int i = 1; i < length; ++i) {
			sum[i][0] = sum[i - 1][1];
			sum[i][1] = min(sum[i - 1][0] + cost[i], sum[i - 1][1] + cost[i]);
		}
		return min(sum[length - 1][0], sum[length - 1][1]);

	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}
}
