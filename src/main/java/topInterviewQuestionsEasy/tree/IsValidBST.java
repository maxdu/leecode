package topInterviewQuestionsEasy.tree;

import java.util.Stack;

public class IsValidBST {

	private Stack<Integer> stack;

	// https://blog.csdn.net/derrantcm/article/details/47310557

	public static void main(String[] args) {
		IsValidBST maxDepth = new IsValidBST();
		TreeNode treeNode = TreeNode.build(1, new Integer[] { 5, 1, 4, null, null, 3, 6 });
		System.out.println(String.format("%s", maxDepth.isValidBST(treeNode)));
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

	public boolean isValidBST2(TreeNode root) {

		if (root == null)
			return true;

		stack = new Stack<>();

		inOrder(root);
		int i = stack.pop();
		int j;
		while (!stack.isEmpty()) {
			j = stack.pop();
			if (i <= j) {
				return false;
			}

			i = j;
		}

		return true;
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			stack.push(root.val);
			inOrder(root.right);
		}
	}

}
