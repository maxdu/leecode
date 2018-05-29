package topInterviewQuestionsEasy.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

	public static void main(String[] args) {
		IsSymmetric maxDepth = new IsSymmetric();
		TreeNode treeNode;
		treeNode = TreeNode.build(1, new Integer[] { 1, 2, 2, 3, 4, 4, 3 });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
		treeNode = TreeNode.build(1, new Integer[] { 1, 2, 2, null, 3, null, 3 });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
		treeNode = TreeNode.build(1, new Integer[] { 1, 2, 3, 3, null, 2, null });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
		treeNode = TreeNode.build(1, new Integer[] { 1, 2, 2, null, 3, null, 3 });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
		treeNode = TreeNode.build(1, new Integer[] { 1 });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
		treeNode = TreeNode.build(1, new Integer[] { 1, 2 });
		System.out.println(String.format("%s", maxDepth.isSymmetric(treeNode)));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		else
			return isCheck(root.left, root.right);
	}

	public boolean isCheck(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		else if (p.val != q.val)
			return false;
		return isCheck(p.left, q.right) && isCheck(p.right, q.left);
	}

	public boolean isSymmetricLoop(TreeNode root) {
		TreeNode t1 = root;
		TreeNode t2 = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(root);
		while (!q.isEmpty()) {
			t1 = q.poll();
			t2 = q.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}

	public boolean isSymmetricSillySlow(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		Deque<Integer> deckLeft = new LinkedList<>();
		Deque<Integer> deckRight = new LinkedList<>();
		preOrder(root.left, deckLeft);
		postOrderv(root.right, deckRight);
		if (deckLeft.size() != deckRight.size())
			return false;
		while (!deckLeft.isEmpty() && !deckRight.isEmpty()) {
			if (deckLeft.poll().intValue() != deckRight.pop().intValue())
				return false;
		}
		if (!deckLeft.isEmpty() || !deckRight.isEmpty()) {
			return false;
		}
		return true;

	}

	public void toQueue(TreeNode node, Deque<Integer> deck) {
		if (node == null) {
			deck.offer(Integer.MIN_VALUE);
			return;
		}
		deck.offer(node.val);
	}

	public void toStack(TreeNode node, Deque<Integer> deck) {
		if (node == null) {
			deck.push(Integer.MIN_VALUE);
			return;
		}
		deck.push(node.val);
	}

	public void preOrder(TreeNode node, Deque<Integer> deck) {
		if (node == null)
			return;
		toQueue(node, deck);
		if (node.left != null) {
			preOrder(node.left, deck);
		} else {
			toQueue(null, deck);
		}
		if (node.right != null) {
			preOrder(node.right, deck);
		} else {
			toQueue(null, deck);
		}
	}

	public void postOrderv(TreeNode node, Deque<Integer> deck) {
		if (node == null)
			return;
		if (node.left != null) {
			postOrderv(node.left, deck);
		} else {
			toStack(null, deck);
		}
		if (node.right != null) {
			postOrderv(node.right, deck);
		} else {
			toStack(null, deck);
		}
		toStack(node, deck);
	}

}
