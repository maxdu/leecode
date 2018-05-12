package topInterviewQuestionsEasy.arrays;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1
 * /array/21/
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatedValue {

	public static void main(String[] args) throws InterruptedException {
		RemoveDuplicatedValue instance = new RemoveDuplicatedValue();
		int[] nums = {};
		int result = 0;

		nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		result = instance.removeDuplicatesFailed(nums);
		for (int i = 0; i < result; i++) {
			System.out.println(nums[i]);
		}

		nums = new int[] { 1, 1, 2 };
		result = instance.removeDuplicatesFailed(nums);
		for (int i = 0; i < result; i++) {
			System.out.println(nums[i]);
		}

		nums = new int[] { 1, 2, 2 };
		result = instance.removeDuplicatesFailed(nums);
		for (int i = 0; i < result; i++) {
			System.out.println(nums[i]);
		}

		nums = new int[] { -3, -1, 0, 0, 0, 3, 3 };
		result = instance.removeDuplicatesFailed(nums);
		for (int i = 0; i < result; i++) {
			System.out.println(nums[i]);
		}

	}

	/*
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * solution/ Since the array is already sorted, we can keep two pointers ii
	 * and jj, where ii is the slow-runner while jj is the fast-runner. As long
	 * as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the
	 * duplicate. When we encounter nums[j] \neq nums[i]nums[j]≠nums[i], the
	 * duplicate run has ended so we must copy its value to nums[i +
	 * 1]nums[i+1]. ii is then incremented and we repeat the same process again
	 * until jj reaches the end of array.
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	// wrong implementaion, the question it self not actually careing about
	// 'remove'. just a funny way to solve the issue.
	public int removeDuplicatesFailed(int[] nums) throws InterruptedException {

		if (nums.length == 0)
			return 0;

		int filler = nums[nums.length - 1] == 0 ? 1 : nums[nums.length - 1] * 2;

		int actualSize = nums.length;

		for (int i = 0; i < nums.length - 1;) {

			if (nums[i] == filler) {
				break;
			}

			if (nums[i] != nums[i + 1]) {
				i++;
				continue;
			}

			if (nums[i] == nums[i + 1]) {
				if (i + 1 == nums.length - 1) {// catch the tail
					nums[i + 1] = filler;
					i++;
				}
				// shift left
				shiftLeft(nums, i + 2, nums.length - (i + 2), filler);
			}

			// debug
			for (int num : nums) {
				System.out.print(num);
			}
			System.out.println();
			Thread.sleep(300);

			actualSize--;
		}
		return actualSize;
	}

	private void shiftLeft(int[] ary, int firstIndex, int bit, int filler) {
		if (firstIndex > ary.length - 1 || firstIndex + bit - 1 > ary.length - 1)
			return;
		if (bit < 0)
			return;
		for (int i = 0; i < bit; i++) {
			ary[firstIndex - 1 + i] = ary[firstIndex + i];
		}
		ary[firstIndex + bit - 1] = filler;
	}

}
