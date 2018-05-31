package topInterviewQuestionsEasy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {

	public static void main(String[] args) {
		SortedArrayToBST satb = new SortedArrayToBST();
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { -10, -3, 0, 5, 9, 12, 14, 17 })));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { -10, -3, 0, 5, 9, 12, 14 })));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { -10 })));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] {})));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { -10, -3, 0, 5, 9 })));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { 1, 3 })));
		 System.out.println(String.format("%s", satb.sortedArrayToBST(new
		 int[] { 0, 1, 2, 3, 4, 5 })));
		System.out.println(
				String.format("%s", satb.sortedArrayToBST(new int[] {-98,-89,-88,-84,-82,-78,-68,-47,-26,-14,-11,-7,-3,2,15,18,50,51,58})));

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
			int prevLayerIndex = 0;
			int leftBound = (int) (offsetLeft - Math.pow(2, procLayerIndex));
			int rightBound = (int) (offsetRight + Math.pow(2, procLayerIndex));
			for (int i = offsetLeft; i > leftBound && i >= 0; i--) {
				System.out.println(String.format("left processing %s", nums[i]));
				TreeNode newLeft = new TreeNode(nums[i]);
				currLayer.add(newLeft);
				if (prevLayer.get(prevLayerIndex).left == null) {
					prevLayer.get(prevLayerIndex).left = newLeft;
				} else if (prevLayer.get(prevLayerIndex).right == null) {
					prevLayer.get(prevLayerIndex).right = newLeft;
					prevLayerIndex++;
				}
				if (prevLayerIndex >= prevLayer.size())
					break;

			}
			for (int i = offsetRight; i < rightBound && i < nums.length; i++) {
				System.out.println(String.format("right processing %s", nums[i]));
				TreeNode newRight = new TreeNode(nums[i]);
				currLayer.add(newRight);
				if (prevLayer.get(prevLayerIndex).left == null) {
					prevLayer.get(prevLayerIndex).left = newRight;
				} else if (prevLayer.get(prevLayerIndex).right == null) {
					prevLayer.get(prevLayerIndex).right = newRight;
					prevLayerIndex++;
				}
				if (prevLayerIndex >= prevLayer.size())
					break;

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

		// check and adjust whole tree
		while (!isValidBST(root)) {
			for (int procLayerIndex = 0; procLayerIndex < maxLayers; procLayerIndex++) {
				List<TreeNode> currLayer = layerNodes.get(procLayerIndex);
				currLayer.forEach(x -> {
					TreeNode leftMax = getMax(x.left);
					TreeNode rightMin = getMin(x.right);
					adjust(leftMax, x, rightMin);
					layerNodes.forEach(xx -> {
						System.out.println();
						xx.forEach(yy -> System.out.print(" " + yy.val));
					});
					System.out.println();
				});
			}
		}

		layerNodes.forEach(x -> {
			System.out.println();
			x.forEach(y -> System.out.print(" " + y.val));
		});
		System.out.println();

		return root;
	}

	public TreeNode getMax(TreeNode node) {

		if (node == null)
			return node;

		if (node.left == null && node.right == null) {
			return node;

		} else if (node.left != null && node.right != null) {
			TreeNode leftMax = getMax(node.left);
			TreeNode rightMax = getMax(node.right);
			if (node.val > leftMax.val && node.val > rightMax.val) {
				return node;
			}
			if (leftMax.val > node.val && leftMax.val > rightMax.val) {
				return leftMax;
			}
			if (rightMax.val > leftMax.val && rightMax.val > node.val) {
				return rightMax;
			}
		} else {
			if (node.left != null) {
				TreeNode leftMax = getMax(node.left);
				if (node.val > leftMax.val) {
					return node;
				} else {
					return leftMax;
				}
			} else {
				TreeNode rightMax = getMax(node.right);
				if (node.val > rightMax.val) {
					return node;
				} else {
					return rightMax;
				}
			}
		}

		return node;

	}

	public TreeNode getMin(TreeNode node) {

		if (node == null)
			return node;

		if (node.left == null && node.right == null) {
			return node;

		} else if (node.left != null && node.right != null) {
			TreeNode leftMin = getMax(node.left);
			TreeNode rightMin = getMax(node.right);
			if (node.val < leftMin.val && node.val < rightMin.val) {
				return node;
			}
			if (leftMin.val < node.val && leftMin.val < rightMin.val) {
				return leftMin;
			}
			if (rightMin.val < leftMin.val && rightMin.val < node.val) {
				return rightMin;
			}
		} else {
			if (node.left != null) {
				TreeNode leftMax = getMax(node.left);
				if (node.val < leftMax.val) {
					return node;
				} else {
					return leftMax;
				}
			} else {
				TreeNode rightMax = getMax(node.right);
				if (node.val < rightMax.val) {
					return node;
				} else {
					return rightMax;
				}
			}
		}

		return node;

	}

	public void adjust(TreeNode leftLeaf, TreeNode root, TreeNode rightLeaf) {
		if (leftLeaf == null && rightLeaf == null) {
			return;

		} else if (leftLeaf != null && rightLeaf != null) {
			int left = leftLeaf.val;
			int mid = root.val;
			int right = rightLeaf.val;
			int[] sorted = new int[] { left, mid, right };
			Arrays.sort(sorted);
			leftLeaf.val = sorted[0];
			root.val = sorted[1];
			rightLeaf.val = sorted[2];

		} else {
			if (leftLeaf != null && leftLeaf.val > root.val) {
				int temp = root.val;
				root.val = leftLeaf.val;
				leftLeaf.val = temp;
			}
			if (rightLeaf != null && rightLeaf.val < root.val) {
				int temp = root.val;
				root.val = rightLeaf.val;
				rightLeaf.val = temp;
			}
		}
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

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean valid(TreeNode node, long mn, long mx) {
		if (node == null)
			return true;

		if (node.val <= mn || node.val >= mx) {
			return false;
		}
		return valid(node.left, mn, node.val) && valid(node.right, node.val, mx);
	}
}
