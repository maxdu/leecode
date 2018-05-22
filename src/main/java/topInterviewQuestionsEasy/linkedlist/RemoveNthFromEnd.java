package topInterviewQuestionsEasy.linkedlist;

public class RemoveNthFromEnd {

	public static void main(String[] args) {

		RemoveNthFromEnd rs = new RemoveNthFromEnd();
		ListNode ln;

		ln = ListNode.getNoCycleList7();
		ListNode.printAll(rs.removeNthFromEnd(ln, 7));
		System.out.println();

		ln = ListNode.getNoCycleList7();
		ListNode.printAll(rs.removeNthFromEnd(ln, 1));
		System.out.println();

		ln = ListNode.getNoCycleList7();
		ListNode.printAll(rs.removeNthFromEnd(ln, 3));
		System.out.println();

		ln = ListNode.getNoCycleList2();
		ListNode.printAll(rs.removeNthFromEnd(ln, 1));
		System.out.println();

		ln = ListNode.getNoCycleList2();
		ListNode.printAll(rs.removeNthFromEnd(ln, 2));
		System.out.println();
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head.next == null) {
			return null;
		}

		ListNode byOnePre = head;
		ListNode byOne = head;
		ListNode byN = head;
		boolean byNreachEnd = false;
		int lengthByN = 1;
		int lengthByOne = 1;
		int changePoint = -1;
		while (byOne != null) {
			if (!byNreachEnd) {
				for (int i = 0; i < n; i++) {
					if (byN.next != null) {
						byN = byN.next;
						lengthByN++;
					} else {
						byNreachEnd = true;
						changePoint = lengthByN - n + 1;
						break;
					}
				}
			}
			if (changePoint == 1) {
				return head.next;
			}
			if (changePoint > 0 && lengthByOne >= changePoint) {
				byOnePre.next = byOnePre.next.next;
				break;
			}
			byOnePre = byOne;
			byOne = byOne.next;
			lengthByOne++;
		}
		return head;

	}

}
