package topInterviewQuestionsEasy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {

	public static void main(String[] args) {
		SortedArrayToBST satb = new SortedArrayToBST();
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { -10, -3, 0, 5, 9, 12, 14, 17 })));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { -10, -3, 0, 5, 9, 12, 14 })));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { -10 })));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] {})));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { -10, -3, 0, 5, 9 })));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { 1, 3 })));
		// System.out.println(String.format("%s", satb.sortedArrayToBST(new
		// int[] { 0, 1, 2, 3, 4, 5 })));
		System.out.println(String.format("%s", satb.sortedArrayToBST(new int[] { 0, 1, 2, 3, 4, 5, 6 })));

	}

	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		TreeNode root = getMiddleNode(nums, 0, nums.length - 1);

		return root;
	}

	private TreeNode getMiddleNode(int[] nums, int start, int end) {

		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		TreeNode node = new TreeNode(nums[middle]);
		node.left = getMiddleNode(nums, start, middle - 1);
		node.right = getMiddleNode(nums, middle + 1, end);
		return node;
	}

	public TreeNode sortedArrayToBSTSlow(int[] nums) {

		if (nums.length == 0)
			return null;

		TreeNode root = getMiddleNode(nums);

		return root;
	}

	private TreeNode getMiddleNode(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		int middle = nums.length / 2;
		TreeNode node = new TreeNode(nums[middle]);
		if (middle > 0) {
			node.left = getMiddleNode(Arrays.copyOfRange(nums, 0, middle));
		}
		if (nums.length > middle + 1) {
			node.right = getMiddleNode(Arrays.copyOfRange(nums, middle + 1, nums.length));
		}
		return node;
	}

}
