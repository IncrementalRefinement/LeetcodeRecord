package answers;

import util.ListNode;

public class No00019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();
        ListNode fast = fakeHead, slow = fakeHead;
        fakeHead.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
