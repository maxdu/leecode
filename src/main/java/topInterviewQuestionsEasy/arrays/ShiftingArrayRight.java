package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1
 * /array/23/
 */
public class ShiftingArrayRight {

	public static void main(String[] args) throws InterruptedException {
		ShiftingArrayRight instance = new ShiftingArrayRight();

		int nums[] = {};
		int k = -1;

		// case1
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = 3;
		instance.showTheWork(nums, doTheWork1(Arrays.copyOf(nums, nums.length), k));
		instance.showTheWork(nums, doTheWork2(Arrays.copyOf(nums, nums.length), k));
		instance.showTheWork(nums, doTheWork3(Arrays.copyOf(nums, nums.length), k));

		// case2
		nums = new int[] { -1, -100, 3, 99 };
		k = 2;
		instance.showTheWork(nums, doTheWork1(Arrays.copyOf(nums, nums.length), k));
		instance.showTheWork(nums, doTheWork2(Arrays.copyOf(nums, nums.length), k));
		instance.showTheWork(nums, doTheWork3(Arrays.copyOf(nums, nums.length), k));
	}

	public static int[] doTheWork1(int[] nums, int shiftBits) {

		System.out.println("");
		System.out.println("Way1:");

		// k times
		for (int s = 1; s <= shiftBits; s++) {
			// save the tail(right most)
			int temp = nums[nums.length - 1];

			// shifting
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			// old tail goes head
			nums[0] = temp;
		}

		return nums;

	}

	// direct swap
	public static int[] doTheWork2_deadend(int[] nums, int shiftBits) {

		System.out.println("");
		System.out.println("Way2:");

		int OffSet = nums.length;
		// start from 0
		int fromValue = nums[0];
		int toValue = nums[0];
		int processingIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.println();
			Arrays.stream(nums).forEach(x -> System.out.print(" " + x));
			int destinationIndex = processingIndex + shiftBits;
			if (destinationIndex >= nums.length)
				destinationIndex -= OffSet;
			toValue = nums[destinationIndex];
			nums[destinationIndex] = fromValue;
			fromValue = toValue;
			processingIndex = destinationIndex;
		}
		System.out.println();

		return nums;

	}

	public static int[] doTheWork2(int[] nums, int shiftBits) {

		System.out.println("");
		System.out.println("Way2:");

		shiftBits = shiftBits % nums.length;
		int count = 0;

		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int previous = nums[current];
			do {
				int next = (current + shiftBits) % nums.length;
				int temp = nums[next];
				nums[next] = previous;
				previous = temp;
				current = next;
				count++;

			} while (start != current);
		}

		return nums;

	}

	public static int[] doTheWork3(int[] nums, int shiftBits) {

		System.out.println("");
		System.out.println("Way3:");

		// reverse all numbers
		reverse(nums, 0, nums.length - 1);

		// reverse first shiftBits
		reverse(nums, 0, shiftBits - 1);

		// reverse remainings
		reverse(nums, shiftBits, nums.length - 1);

		return nums;

	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public void showTheWork(int[] original, int[] after) {
		Arrays.stream(original).forEach(x -> System.out.print(" " + x));
		System.out.println();
		Arrays.stream(after).forEach(x -> System.out.print(" " + x));
		System.out.println();
	}

}
