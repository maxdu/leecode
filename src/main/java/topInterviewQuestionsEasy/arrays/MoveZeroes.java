package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoveZeroes {

	public MoveZeroes() {

	}

	public static void main(String[] args) {

		MoveZeroes instance = new MoveZeroes();

		int[] num = new int[] { 0, 1, 0, 3, 12 };

		instance.moveZeroes(num);

		Arrays.stream(num).forEach(System.out::println);
		System.out.println();

		num = new int[] { 1, 1, 3, 0, 12 };

		instance.moveZeroes(num);

		Arrays.stream(num).forEach(System.out::println);
		System.out.println();
	}

	public void moveZeroes(int[] nums) {
		if (nums.length == 0)
			return;

		// find all zeros
		int count = 0;
		for (int num : nums) {
			if (num == 0)
				count++;
		}

		if (count == 0) {
			return;
		}

		// direct shift
		int offset = 0;
		int procIndex = 0;
		for (int i = 0; i < nums.length - count; i++) {
			// find next none-0 to shift
			while (nums[offset] == 0) {
				offset++;
			}
			// shift none-0 to target loc, if procIndex!=offset
			if (procIndex != offset) {
				nums[procIndex] = nums[offset];
				nums[offset] = 0;
			}
			offset++;
			procIndex++;
		}

		return;
	}

}
