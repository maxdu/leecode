package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;

public class ContainsDuplicate {

	public ContainsDuplicate() {

	}

	public static void main(String[] args) {

		ContainsDuplicate instance = new ContainsDuplicate();
		System.out.println(instance.containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(instance.containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(instance.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));

	}

	// Naive Linear Search O(n2)
	public boolean containsDuplicateNLS(int[] nums) {
		if (nums.length < 2) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// sorting
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);// O(nlogn)
		if (nums.length < 2) {
			return false;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

}
