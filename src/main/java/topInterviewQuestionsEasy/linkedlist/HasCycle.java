package topInterviewQuestionsEasy.linkedlist;

public class HasCycle {

	public static void main(String[] args) {

		HasCycle rs = new HasCycle();

		System.out.println(String.format("%s", rs.hasCycle(ListNode.getCycleList())));
		System.out.println(String.format("%s", rs.hasCycle(ListNode.getNoCycleList())));
		System.out.println(String.format("%s", rs.hasCycle(ListNode.getCycleList2())));

	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public boolean hasCycleSlow(ListNode head) {
		if (head == null)
			return false;

		ListNode slowNode = head;
		// System.out.println(String.format("slow Val = %s", slowNode.val));
		ListNode fastNode = null;
		if (slowNode.next != null) {
			fastNode = slowNode.next;
			// System.out.println(String.format("fast Val = %s", fastNode.val));
		}

		while (slowNode != null && fastNode != null && slowNode.next != null && fastNode.next != null
				&& slowNode.val != fastNode.val) {
			if (slowNode.next == null) {
				slowNode = null;
			} else {
				slowNode = slowNode.next;
				// System.out.println(String.format("slow Val = %s",
				// slowNode.val));
			}
			if (fastNode.next == null) {
				fastNode = null;
			} else {
				fastNode = fastNode.next;
				if (fastNode.next == null) {
					fastNode = null;
				} else {
					fastNode = fastNode.next;
					// System.out.println(String.format("fast Val = %s",
					// fastNode.val));
				}
			}

		}

		if (slowNode != null && fastNode != null && slowNode.val == fastNode.val) {
			return true;
		} else {
			return false;
		}
	}

}
