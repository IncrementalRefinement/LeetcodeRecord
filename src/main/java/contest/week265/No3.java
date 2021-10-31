package contest.week265;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class No3 {
    // BFS
    public static int minimumOperations(int[] nums, int start, int goal) {
        HashSet<Integer> memo = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        int depth = 0;
        deque.add(start);
        while (deque.size() > 0) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                int item = deque.removeFirst();
                if (memo.contains(item)) continue;
                memo.add(item);
                if (item == goal) {
                    return depth;
                } else if (item >= 0 && item <= 1000){
                    for (int num : nums) {
                        if (!memo.contains(item + num)) {
                            deque.addLast(item + num);
                        }
                        if (!memo.contains(item - num)) {
                            deque.addLast(item - num);
                        }
                        if (!memo.contains(item ^ num)) {
                            deque.addLast(item ^ num);
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{2, 8, 16}, 0, 1));
        System.out.println(minimumOperations(new int[]{2, 4, 12}, 2, 12));
    }
}
