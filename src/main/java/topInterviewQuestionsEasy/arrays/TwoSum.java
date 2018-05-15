package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public TwoSum() {

	}

	public static void main(String[] args) {

		TwoSum instance = new TwoSum();

		// Arrays.stream(instance.twoSum(new int[] { },
		// 9)).forEach(System.out::println);
		Arrays.stream(instance.twoSum(new int[] { 3, 3}, 6)).forEach(System.out::println);
		System.out.println();
	}

	public int[] twoSum(int[] nums, int target) {
		// sort it
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		for (int i = 0; i <= copy.length; i++) {
			int j = copy.length - 1;
			while (j > i) {
				//System.out.println(String.format("i %s val %s, j %s val %s", i, copy[i], j, copy[j]));
				if (copy[i] + copy[j] == target) {
					System.out.println("found");
					int x = -1, y = -1;
					for (int ii = 0; ii < nums.length; ii++) {
						if (nums[ii] == copy[i] && x == -1) {
							x = ii;
							continue;
						}
						if (nums[ii] == copy[j] && y == -1) {
							y = ii;
						}
						if (x != -1 && y != -1)
							break;
					}
					return new int[] { x, y };
				}
				j--;
			}

		}
		return new int[] {};

	}

}
