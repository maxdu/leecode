package topInterviewQuestionsEasy.linkedlist;

public class MergeTwoLists {

	// https://blog.csdn.net/a1414345/article/details/52641794

	public static void main(String[] args) {

		MergeTwoLists rs = new MergeTwoLists();
		ListNode.printAll(rs.mergeTwoLists(ListNode.getNoCycleList(4, 1), ListNode.getNoCycleList(5, 2)));
		System.out.println();
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		System.out.println(String.format("L1 %s, L2 %s", l1 == null ? "" : l1.val, l2 == null ? "" : l2.val));
		ListNode newHead = null;
		if (l1 == null) {
			System.out.println("l1 == null");
			return l2;
		} else if (l2 == null) {
			System.out.println("l2 == null");
			return l2;
		} else {
			if (l1.val < l2.val) {
				System.out.println("l1.val < l2.val");
				newHead = l1;
				newHead.next = mergeTwoLists(l1.next, l2);
				System.out.println(String.format("l1.val %s < l2.val %s after", l1.val, l2.val));
			} else {
				System.out.println("l1.val >= l2.val");
				newHead = l2;
				newHead.next = mergeTwoLists(l1, l2.next);
				System.out.println(String.format("l1.val %s < l2.val %s after", l1.val, l2.val));
			}
			return newHead;
		}

	}

}
