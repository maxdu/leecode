package topInterviewQuestionsEasy.linkedlist;

public class DeleteNode {

	public static void main(String[] args) {

		DeleteNode rs = new DeleteNode();
		ListNode ln = ListNode.getNoCycleList2();
		rs.deleteNode(ln);
		ListNode.printAll(ln);
	}

	//TODO don't need shifting value, change the link directly
	public void deleteNode(ListNode node) {
		ListNode newTail = null;
		if (node == null || node.next == null) {
			return;
		}
		if (node.next.next == null) {
			node.val = node.next.val;
			node.next = null;
			return;
		}
		while (node != null && node.next != null) {
			node.val = node.next.val;
			node = node.next;
			if (node.next != null && node.next.next == null) {
				newTail = node;
			}
		}
		newTail.next = null;
	}

}
