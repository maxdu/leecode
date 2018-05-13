package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public SingleNumber() {

	}

	public static void main(String[] args) {

		SingleNumber instance = new SingleNumber();
		System.out.println(instance.singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(instance.singleNumber(new int[] { 4, 1, 2, 1, 2 }));

	}

	public int singleNumber(int[] nums) {
		if (nums.length % 2 == 0) {
			return nums[0];
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i = i + 2) {
			if (nums[i] != nums[i + 1])
				return nums[i];
		}
		return nums[nums.length - 1];
	}

}
