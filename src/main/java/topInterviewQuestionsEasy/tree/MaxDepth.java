package topInterviewQuestionsEasy.tree;

public class MaxDepth {

	public static void main(String[] args) {
		MaxDepth maxDepth = new MaxDepth();
		TreeNode treeNode = TreeNode.build(1, new Integer[] { 3, 9, 20, null, null, 15, 7 });
		System.out.println(String.format("Depth is %s", maxDepth.maxDepth(treeNode)));
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if (leftDepth >= rightDepth) {
			return 1 + leftDepth;
		} else {
			return 1 + rightDepth;
		}

	}

	public int maxDepthRedundentNullCheck(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = 0;
		int rightDepth = 0;
		if (root.left != null) {
			leftDepth = maxDepth(root.left);
		}
		if (root.right != null) {
			rightDepth = maxDepth(root.right);
		}
		if (leftDepth >= rightDepth) {
			return 1 + leftDepth;
		} else {
			return 1 + rightDepth;
		}

	}

}
