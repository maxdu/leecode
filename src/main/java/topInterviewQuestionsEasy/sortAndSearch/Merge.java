package topInterviewQuestionsEasy.sortAndSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Merge {

	public Merge() {

	}

	public static void main(String[] args) {

		Merge instance = new Merge();
		int[] toAry = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] fromAry = new int[] { 2, 5, 6 };
		instance.merge(toAry, 3, fromAry, 3);
		System.out.println("finally");
		print(toAry, fromAry);

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int point1 = m - 1;
		int point2 = n - 1;
		int slot = n + m - 1;

		//print(nums1, nums2);
		while (point1 >= 0 && point2 >= 0) {
			if (nums1[point1] >= nums2[point2]) {
				nums1[slot] = nums1[point1];
				point1--;

			} else {
				nums1[slot] = nums2[point2];
				point2--;
			}
			slot--;
			//print(nums1, nums2);
		}
		while (point2 >= 0) {
			nums1[slot] = nums2[point2];
			point2--;
			slot--;
			//print(nums1, nums2);
		}
		while (point1 >= 0) {
			nums1[slot] = nums1[point1];
			point1--;
			slot--;
			//print(nums1, nums2);
		}
	}

	private static void print(int[] nums1, int[] nums2) {
		Arrays.stream(nums1).forEach(x -> System.out.print(" " + x));
		System.out.println();
		Arrays.stream(nums2).forEach(x -> System.out.print(" " + x));
		System.out.println();

	}

}
