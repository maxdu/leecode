package topInterviewQuestionsEasy.linkedlist;

public class RemoveNthFromBegin {

	public static void main(String[] args) {

		RemoveNthFromBegin rs = new RemoveNthFromBegin();
		ListNode ln;
		
		ln = ListNode.getNoCycleList2();
		rs.removeNthFromEnd(ln, 2);
		ListNode.printAll(ln);
		System.out.println();
		
		ln = ListNode.getNoCycleList2();
		rs.removeNthFromEnd(ln, 1);
		ListNode.printAll(ln);
		System.out.println();		

		ln = ListNode.getNoCycleList7();
		rs.removeNthFromEnd(ln, 3);
		ListNode.printAll(ln);
		System.out.println();
		
		ln = ListNode.getNoCycleList7();
		rs.removeNthFromEnd(ln, 1);
		ListNode.printAll(ln);
	}

	//TODO don't need shifting value, change the link directly
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode newHead = head;
		ListNode newTail = head;
		while (head.next != null) {
			if (count + 1 >= n) {
				head.val = head.next.val;
			}
			if (head.next.next == null) {
				newTail = head;
			}
			head = head.next;
			count++;
		}
		newTail.next = null;
		return newHead;

	}

}
