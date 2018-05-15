package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlusOne {

	public PlusOne() {

	}

	public static void main(String[] args) {

		PlusOne instance = new PlusOne();

		Arrays.stream(instance.plusOne(new int[] { 2, 2, 1 })).forEach(System.out::println);
		System.out.println();
		Arrays.stream(instance.plusOne(new int[] { 1, 9, 9 })).forEach(System.out::println);
		System.out.println();
		Arrays.stream(instance.plusOne(new int[] { 9, 9 })).forEach(System.out::println);
		System.out.println();
		Arrays.stream(instance.plusOne(new int[] { 9 })).forEach(System.out::println);

	}

	public int[] plusOne(int[] digits) {
		int[] ret = new int[digits.length + 1];
		int digi = digits.length;
		int checking = digi - 1;
		boolean inc = true;
		while (checking >= 0) {
			if (inc) {
				digits[checking] += 1;
			}
			if (digits[checking] == 10) {
				digits[checking] = 0;
			} else {
				inc = false;
			}
			ret[checking + 1] = digits[checking];
			checking -= 1;
		}
		if (digits[0] == 0) {
			ret[0] = 1;
			return ret;
		} else {
			return digits;
		}

	}

}
