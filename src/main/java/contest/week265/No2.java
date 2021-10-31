package contest.week265;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class No2 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode ptrBefore = head;
        ListNode ptrCurrent = head.next;
        List<Integer> indexes = new ArrayList<>();
        int[] res = new int[2];
        int index = 1;
        while (ptrCurrent != null && ptrCurrent.next != null) {
            if (ptrCurrent.val > ptrBefore.val && ptrCurrent.val > ptrCurrent.next.val) {
                indexes.add(index);
            } else if (ptrCurrent.val < ptrBefore.val && ptrCurrent.val < ptrCurrent.next.val) {
                indexes.add(index);
            }
            index++;
            ptrBefore = ptrCurrent;
            ptrCurrent = ptrCurrent.next;
        }
        if (indexes.size() <= 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[1] = indexes.get(indexes.size() - 1) - indexes.get(0);
        res[0] = indexes.get(1) - indexes.get(0);
        for (int i = 0; i < indexes.size() - 1; i++) {
            int temp = indexes.get(i + 1) - indexes.get(i);
            if (temp < res[0]) {
                res[0] = temp;
            }
        }

        return res;
    }
}
