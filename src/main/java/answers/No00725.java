package answers;

import util.ListNode;

public class No00725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ptr = head;
        int listLen = 0;

        while (ptr != null) {
            ptr = ptr.next;
            listLen++;
        }
        ListNode[] splitedNodes = new ListNode[listLen];
        int averageLen = listLen / k;
        int overflow = listLen % k;

        ptr = head;

        for (int i = 0; i < overflow; i++) {
            ListNode tempHead = null;
            for (int j = 0; j < averageLen + 1; j ++) {
                if (tempHead == null) {
                    splitedNodes[i] = ptr;
                    tempHead = ptr;
                } else {
                    tempHead.next = ptr;
                    tempHead = tempHead.next;
                    head = head.next;
                }
            }
        }

        for (int i = overflow; i < averageLen; i++) {
            ListNode tempHead = null;
            for (int j = 0; j < averageLen; j ++) {
                if (tempHead == null) {
                    splitedNodes[i] = ptr;
                    tempHead = ptr;
                } else {
                    tempHead.next = ptr;
                    tempHead = tempHead.next;
                    head = head.next;
                }
            }
        }

        return splitedNodes;
    }

    public static void main(String[] args) {
        // TODO: write test code
    }
}
