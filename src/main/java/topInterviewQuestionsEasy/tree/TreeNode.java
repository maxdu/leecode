package topInterviewQuestionsEasy.tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

	// https://blog.csdn.net/ls5718/article/details/51226674
	// https://www.cnblogs.com/llguanli/p/7363657.html

	public Integer val;
	public TreeNode left;
	public TreeNode right;
	public int id;

	public TreeNode(Integer x) {
		if (x != null) {
			val = x;
		}
		id = new BigDecimal(Math.random() * 1000).intValue();
	}

	public static void main(String[] args) {
		// TreeNode tree = TreeNode.build(1, new Integer[] { 3, 9, 20, null,
		// null, 15, 7 });
		TreeNode tree = TreeNode.build(1, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		// System.out.println(tree.id);
		// System.out.println();

		preOrderTraversal(tree);
		System.out.println();

		preOrderTraversalByLoop(tree);
		System.out.println();

		inOrderTraversal(tree);
		System.out.println();

		inOrderTraversalByLoop(tree);
		System.out.println();

		postOrderTraversal(tree);
		System.out.println();

		postOrderTraversalByLoop(tree);
		System.out.println();
		
		bfs(tree);
		System.out.println();
		
		List<List<Integer>> rst = new ArrayList<>();  
        List<Integer> list = new ArrayList<>();  
        deepPathSearch(tree,rst,list);  
        System.out.println(rst);  
	}

	public static void printAll(TreeNode node) {

	}

	static TreeNode build(int index, Integer[] nodeValues) {
		if (index > nodeValues.length || nodeValues[index - 1] == null)
			return null;
		TreeNode curr = new TreeNode(nodeValues[index - 1]);
		curr.left = build(2 * index, nodeValues);
		curr.right = build(2 * index + 1, nodeValues);
		return curr;
	}

	static void checkCurrent(TreeNode node) {
		// System.out.println(String.format("current node id %s ,value %s",
		// node.id, node.val));
		System.out.print(String.format("%s ", node.val));
	}

	static void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		checkCurrent(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	static void preOrderTraversalByLoop(TreeNode node) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {// 当p不为空时，就读取p的值，并不断更新p为其左子节点，即不断读取左子节点
				checkCurrent(p);
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.right;
			}
		}
	}

	static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		checkCurrent(node);
		inOrderTraversal(node.right);
	}

	static void inOrderTraversalByLoop(TreeNode node) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				checkCurrent(p);
				p = p.right;
			}
		}
	}

	static void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		checkCurrent(node);
	}

	static void postOrderTraversalByLoop(TreeNode node) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = node;
		TreeNode prev = node;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				TreeNode temp = stack.peek().right;
				if (temp == null || temp == prev) {
					p = stack.pop();
					checkCurrent(p);
					prev = p;
					p = null;
				} else {
					p = temp;
				}
			}
		}
	}

	static void bfs(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			TreeNode node = queue.poll();
			checkCurrent(node);
			if(node.left!=null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}

		}

	}
	
	static void deepPathSearch(TreeNode node, List<List<Integer>> rst,List<Integer> list) {
		if (node == null)
			return;		
		if(node.left == null && node.right == null){  
            list.add(node.val);  
            /* 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现， 
             * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉*/  
            rst.add(new ArrayList<>(list));  
            list.remove(list.size()-1);  
        }  
        list.add(node.val);  
        deepPathSearch(node.left,rst,list);  
        deepPathSearch(node.right,rst,list);  
        list.remove(list.size()-1);  

	}
	
	

}
