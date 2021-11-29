package category.twopointer;

import util.ListNode;

public class No00142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode fast = head, slow = head;
        boolean isCyclic = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCyclic = true;
                break;
            }
        }

        if (!isCyclic) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
