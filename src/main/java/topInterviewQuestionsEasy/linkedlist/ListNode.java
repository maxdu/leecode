package topInterviewQuestionsEasy.linkedlist;

public class ListNode {

	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public static void main(String[] args) {
		ListNode.printAll(ListNode.getNoCycleList(4, 1));

		ListNode.printAll(ListNode.getNoCycleList(5, 3));
	}

	public static ListNode getNoCycleList2() {

		ListNode noCycleHeadNode = new ListNode(1);

		ListNode noCycleMidNode2 = new ListNode(2);
		noCycleHeadNode.next = noCycleMidNode2;

		/*
		 * ListNode noCycleMidNode3 = new ListNode(3); noCycleMidNode2.next =
		 * noCycleMidNode3;
		 * 
		 * ListNode noCycleMidNode4 = new ListNode(4); noCycleMidNode3.next =
		 * noCycleMidNode4;
		 * 
		 * ListNode noCycleMidNode5 = new ListNode(5); noCycleMidNode4.next =
		 * noCycleMidNode5;
		 * 
		 * ListNode noCycleMidNode6 = new ListNode(6); noCycleMidNode5.next =
		 * noCycleMidNode6;
		 * 
		 * ListNode noCycleTailNode = new ListNode(7); noCycleMidNode6.next =
		 * noCycleTailNode;
		 */

		return noCycleHeadNode;
	}

	public static ListNode getNoCycleList1() {

		ListNode noCycleHeadNode = new ListNode(1);

		return noCycleHeadNode;
	}

	public static ListNode getNoCycleList7() {

		ListNode noCycleHeadNode = new ListNode(1);

		ListNode noCycleMidNode2 = new ListNode(2);
		noCycleHeadNode.next = noCycleMidNode2;

		ListNode noCycleMidNode3 = new ListNode(3);
		noCycleMidNode2.next = noCycleMidNode3;

		ListNode noCycleMidNode4 = new ListNode(4);
		noCycleMidNode3.next = noCycleMidNode4;

		ListNode noCycleMidNode5 = new ListNode(5);
		noCycleMidNode4.next = noCycleMidNode5;

		ListNode noCycleMidNode6 = new ListNode(6);
		noCycleMidNode5.next = noCycleMidNode6;

		ListNode noCycleTailNode = new ListNode(7);
		noCycleMidNode6.next = noCycleTailNode;

		return noCycleHeadNode;
	}

	public static ListNode getCycleList() {

		ListNode hasCycleHeadNode = new ListNode(1);

		ListNode hasCycleMidNode2 = new ListNode(2);
		hasCycleHeadNode.next = hasCycleMidNode2;

		ListNode hasCycleMidNode3 = new ListNode(3);
		hasCycleMidNode2.next = hasCycleMidNode3;
		hasCycleMidNode3.next = hasCycleMidNode3;

		return hasCycleHeadNode;
	}

	public static ListNode getCycleList2() {

		ListNode hasCycleHeadNode = new ListNode(1);

		ListNode hasCycleMidNode2 = new ListNode(2);
		hasCycleHeadNode.next = hasCycleMidNode2;

		hasCycleMidNode2.next = hasCycleHeadNode;

		return hasCycleHeadNode;
	}

	public static void printAll(ListNode node) {
		System.out.println();
		System.out.println(String.format("node %s, value %s, next %s", System.identityHashCode(node), node.val,
				System.identityHashCode(node.next)));
		while (node.next != null) {
			node = node.next;
			System.out.println(String.format("node %s, value %s, next %s", System.identityHashCode(node), node.val,
					System.identityHashCode(node.next)));
		}

	}

	public static ListNode getNoCycleList(int size, int mutipler) {

		int i = 1;
		ListNode head = new ListNode(i++ * mutipler);
		ListNode node = head;
		for (; i <= size;) {
			node.next = new ListNode(i++ * mutipler);
			node = node.next;
		}
		return head;
	}
}
