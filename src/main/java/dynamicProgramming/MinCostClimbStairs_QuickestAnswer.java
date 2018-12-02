package dynamicProgramming;

public class MinCostClimbStairs_QuickestAnswer {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

	}

	public static int[] cache;

	public static int solve(int idx, int[] nums) {
		// 如果写成了nums.length - 1,肯定会出现下标越界，因为走到了15的位置还会判断走两步的情况nums[idx + 2]越界
		if (idx >= nums.length - 2) {
			System.out.println(String.format("solving idx=%s, last cached=0", idx));
			return 0;// 一旦走到了倒数第二个台阶就不需要耗费体力了(直接走两步)
		}
		if (cache[idx] >= 0) {// 已经算过
			System.out.println(String.format("solving idx=%s, cached=%s", idx, cache[idx]));
			return cache[idx];
		}
		System.out.println(String.format("to solve min of (%s, %s)", idx + 1, idx + 2));
		cache[idx] = Math.min(solve(idx + 1, nums) + nums[idx + 1], solve(idx + 2, nums) + nums[idx + 2]);
		return cache[idx];
	}

	public static int minCostClimbingStairs(int[] nums) {
		cache = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			cache[i] = -1;
		}
		return Math.min(solve(0, nums) + nums[0], solve(1, nums) + nums[1]);
	}
}
