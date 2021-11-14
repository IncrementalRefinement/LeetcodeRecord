package contest.week267;

import util.ListNode;

public class No2 {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode fakeHead = new ListNode(0, head);
        fakeHead.next = helper(fakeHead.next, 1);
        return fakeHead.next;
    }

    private static ListNode helper(ListNode head, int n) {
        if (head == null) return null;
        int i = 1;
        ListNode ptr = head;
        while (i < n && ptr != null && ptr.next != null) {
            ptr = ptr.next;
            i++;
        }
        if (i % 2 == 0) {
            ListNode temp = ptr.next;
            reverse(head, ptr.next);
            head.next = helper(temp, n + 1);
            return ptr;
        } else {
            ptr.next = helper(ptr.next, n + 1);
            return head;
        }
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode ptr = head;
        while (ptr != tail) {
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = constructListNode(new int[]{1,1,0,6});
        System.out.println("Before:");
        printList(head);
        head = reverseEvenLengthGroups(head);
        System.out.println("After: ");
        printList(head);
    }

    private static ListNode constructListNode(int[] input) {
        ListNode head = new ListNode(input[0]);
        ListNode res = head;
        for (int i = 1; i < input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }
        return res;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
