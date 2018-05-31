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

		if (nums.length == 0)
			return null;

		List<List<TreeNode>> layerNodes = new ArrayList<>();
		int maxLayers = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
		int start = nums.length / 2;
		TreeNode root = new TreeNode(nums[start]);
		System.out.println(String.format("root processing %s", nums[start]));
		List<TreeNode> firstLayer = new ArrayList<>();
		firstLayer.add(root);
		layerNodes.add(firstLayer);
		int offsetLeft = start - 1;
		int offsetRight = start + 1;
		for (int procLayerIndex = 0; procLayerIndex < maxLayers; procLayerIndex++) {
			List<TreeNode> prevLayer = layerNodes.get(procLayerIndex);
			List<TreeNode> currLayer = new ArrayList<>();
			int prevLayerIndexLeft = 0;
			int prevLayerIndexRight = prevLayer.size() - 1;
			int leftBound = (int) (offsetLeft - Math.pow(2, procLayerIndex));
			int rightBound = (int) (offsetRight + Math.pow(2, procLayerIndex));
			for (int i = offsetLeft; i > leftBound && i >= 0; i--) {
				System.out.println(String.format("left processing %s", nums[i]));
				TreeNode newLeft = new TreeNode(nums[i]);
				currLayer.add(newLeft);
				if (prevLayer.get(prevLayerIndexLeft).left == null) {
					prevLayer.get(prevLayerIndexLeft).left = newLeft;
					adjust(prevLayer.get(prevLayerIndexLeft));
				} else if (prevLayer.get(prevLayerIndexLeft).right == null) {
					prevLayer.get(prevLayerIndexLeft).right = newLeft;
					adjust(prevLayer.get(prevLayerIndexLeft));
					prevLayerIndexLeft++;
				}

			}
			for (int i = offsetRight; i < rightBound && i < nums.length; i++) {
				System.out.println(String.format("right processing %s", nums[i]));
				TreeNode newRight = new TreeNode(nums[i]);
				currLayer.add(newRight);
				if (prevLayer.get(prevLayerIndexRight).left == null) {
					prevLayer.get(prevLayerIndexRight).left = newRight;
					adjust(prevLayer.get(prevLayerIndexRight));
				} else if (prevLayer.get(prevLayerIndexRight).right == null) {
					prevLayer.get(prevLayerIndexRight).right = newRight;
					adjust(prevLayer.get(prevLayerIndexRight));
					prevLayerIndexRight--;
				}

			}
			layerNodes.add(currLayer);
			offsetLeft = leftBound;
			offsetRight = rightBound;
		}

		layerNodes.forEach(x -> {
			System.out.println();
			x.forEach(y -> System.out.print(" " + y.val));
		});
		System.out.println();

		return root;
	}

	public void adjust(TreeNode node) {
		if (node.left == null && node.right == null) {
			return;

		} else if (node.left != null && node.right != null) {
			int left = node.left.val;
			int mid = node.val;
			int right = node.right.val;
			int[] sorted = new int[] { left, mid, right };
			Arrays.sort(sorted);
			node.left.val = sorted[0];
			node.val = sorted[1];
			node.right.val = sorted[2];

		} else {
			if (node.left != null && node.left.val > node.val) {
				int temp = node.val;
				node.val = node.left.val;
				node.left.val = temp;
			}
			if (node.right != null && node.right.val < node.val) {
				int temp = node.val;
				node.val = node.right.val;
				node.right.val = temp;
			}
		}
	}

}
