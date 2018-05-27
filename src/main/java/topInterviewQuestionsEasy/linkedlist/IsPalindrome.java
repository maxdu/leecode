package topInterviewQuestionsEasy.linkedlist;

public class IsPalindrome {

	public static void main(String[] args) {

		IsPalindrome rs = new IsPalindrome();

		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(7, new int[] { 1, 2, 3, 0, 3, 2, 1 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(6, new int[] { 1, 2, 3, 3, 2, 1 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(2, new int[] { 1, 1 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(1, new int[] { 1 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(7, new int[] { 1, 2, 1, 0, 3, 2, 1 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(6, new int[] { 1, 2, 3, 3, 2, 0 }))));
		System.out.println(String.format("%s", rs.isPalindrome(ListNode.get(2, new int[] { 2, 1 }))));

	}

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;
		if (head.next == null)
			return true;

		ListNode faster = head;
		ListNode previous = null;
		ListNode current = head;
		ListNode orginalNext = head.next;
		ListNode revertHead = new ListNode(-1);
		ListNode halfHead = null;

		int size = 1;
		int pivotIndex = 1;

		boolean passingPivot = false;

		// ListNode.printAll(head);

		while (!passingPivot) {

			orginalNext = current.next;

			if (faster != null && faster.next != null) {
				faster = faster.next;
				size++;
				if (faster != null && faster.next != null) {
					faster = faster.next;
					size++;
				} else {
					passingPivot = true;
					halfHead = getHalfHead(current);
				}
			} else {
				passingPivot = true;
				halfHead = getHalfHead(current);
			}

			revert(current, previous);
			revertHead = getRevertHead(current, size, pivotIndex);
			previous = current;
			current = orginalNext;

			if (passingPivot == false) {
				pivotIndex++;
			}

		}

		// System.out.println("halfHead");
		//
		// ListNode.printAll(halfHead);
		//
		// System.out.println("revertHead");
		//
		// ListNode.printAll(revertHead);

		while (halfHead != null) {
			if (revertHead == null) {
				return false;
			}
			if (halfHead.val != revertHead.val) {
				return false;
			}
			halfHead = halfHead.next;
			revertHead = revertHead.next;
		}

		return true;

	}

	private ListNode getHalfHead(ListNode cur) {
		return cur.next;

	}

	private ListNode getRevertHead(ListNode cur, int size, int halfSize) {
		// System.out.println(String.format("size %s halfsize %s", size,
		// halfSize));
		if (size % halfSize == 0) {
			return cur;
		} else {
			return cur.next;
		}

	}

	private void revert(ListNode cur, ListNode pre) {
		// System.out.println(String.format("reverting %s value %s id %s, point
		// to %s vlaue %s id %s", cur,
		// cur == null ? "" : cur.val, cur == null ? "" : cur.id, pre, pre ==
		// null ? "" : pre.val,
		// pre == null ? "" : pre.id));
		if (pre != null) {
			cur.next = pre;
		} else {
			cur.next = null;
		}
	}

	public boolean isPalindromeWrong(ListNode head) {

		// System.out.println(String.format("%s",
		// rs.isPalindrome(ListNode.get(2, new int[] { 1, 0,1 }))));

		if (head == null)
			return true;
		if (head.next == null)
			return true;

		boolean revert = false;
		int sum = head.val;
		int probe = head.val;

		System.out.println(String.format("sum = %s, probe = %s", sum, probe));

		head = head.next;

		while (head != null) {
			if (head.val == probe && revert == false) {
				revert = true;
				System.out.println(String.format("sub start"));
			}
			if (revert == true) {
				sum -= head.val;
				System.out.println(String.format("sum = %s", sum));
			} else {
				sum += head.val;
				System.out.println(String.format("sum = %s", sum));
			}
			probe = head.val;
			System.out.println(String.format("probe = %s", probe));
			head = head.next;

		}

		if (sum == 0 && revert == true) {
			return true;
		} else {
			return false;
		}
	}

}
