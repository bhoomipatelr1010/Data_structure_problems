package dsa;

public class MaxTwinSumLinkedList {

	public static void main(String[] args) {
		MaxTwinSumLinkedList maxTwinSumLinkedList = new MaxTwinSumLinkedList();
		int value = maxTwinSumLinkedList.pairSum(maxTwinSumLinkedList.createList1());

		ListNode head = maxTwinSumLinkedList.swapPairs(maxTwinSumLinkedList.createList1());
		maxTwinSumLinkedList.displayList(head);
		// System.out.println(value);
	}

	public ListNode createList1() {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(10000);

		l1.next = l2;
		return l1;
	}

	public ListNode createList() {

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(8);
		ListNode l6 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		return l1;
	}

	public void displayList(ListNode head) {
		while (head != null) {
			System.out.print(" >>> " + head.val);
			head = head.next;
		}

	}

	public int pairSum(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		ListNode next = null;
		while (fast != null) {
			fast = fast.next.next;
			next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;

		}

		int max = 0;

		while (next != null) {
			if ((next.val + prev.val) > max) {
				max = next.val + prev.val;
			}
			next = next.next;
			prev = prev.next;

		}

		return max;

	}

	public ListNode swapPairs(ListNode head) {

		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode first = head;
		ListNode second = null;
		ListNode prev = dummy;
		while (first != null && first.next != null) {

			second = first.next;
			first.next = second.next;
			prev.next=second;
			second.next = first;
			prev = first;
			first = first.next;
		}
		return dummy.next;
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
