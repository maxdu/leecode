package topInterviewQuestionsEasy.linkedlist;

public class ReverseList {

	public static void main(String[] args) {

		ReverseList rs = new ReverseList();
		ListNode ln;

		ln = ListNode.getNoCycleList7();
		ListNode.printAll(rs.reverseList(ln));
		System.out.println();

		ln = ListNode.getNoCycleList2();
		ListNode.printAll(rs.reverseList(ln));
		System.out.println();
	}

	public ListNode reverseList(ListNode head) {

		// recursive
		
		System.out.println(head == null ? "" : head.val);

		if (head == null || head.next == null)
			return head;

		ListNode p = head.next;
		ListNode n = reverseList(p);
		head.next = null;
		p.next = head;

		ListNode.printAll(n);
		return n;
	}

	public ListNode reverseListIteration(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode pre = null;
		ListNode curr = head;
		ListNode next = head.next;
		for (; curr != null;) {
			if (curr == head) {
				curr.next = null;
			} else {
				curr.next = pre;
			}
			pre = curr;
			curr = next;
			if (next != null) {
				next = next.next;// tail
			}

		}

		return pre;
	}

}
