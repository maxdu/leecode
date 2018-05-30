package topInterviewQuestionsEasy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

	public static void main(String[] args) {
		LevelOrder LevelOrder = new LevelOrder();
		TreeNode treeNode = TreeNode.build(1, new Integer[] { 3, 9, 20, null, null, 15, 7 });
		System.out.println(LevelOrder.levelOrder(treeNode));
	}

	static List<List<Integer>> result;

	public List<List<Integer>> levelOrderLoop(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> toProcess = new LinkedList<>();
		toProcess.offer(root);
		while (!toProcess.isEmpty()) {
			List<Integer> sameLevel = new ArrayList<>();
			int toProcessLen = toProcess.size();
			for (int i = 0; i < toProcessLen; i++) {
				TreeNode t = toProcess.poll();
				if (t.left != null)
					toProcess.offer(t.left);
				if (t.right != null)
					toProcess.offer(t.right);
				sameLevel.add(t.val);
			}
			if (!sameLevel.isEmpty()) {
				result.add(sameLevel);
			}
		}
		return result;

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		result = new ArrayList<>();
		recursive(root, 0);
		return result;

	}

	public void recursive(TreeNode node, int level) {
		if (node == null)
			return;
		if (result.size() <= level)
			result.add(new ArrayList<Integer>());
		result.get(level).add(node.val);
		recursive(node.left, level + 1);
		recursive(node.right, level + 1);
	}

}
