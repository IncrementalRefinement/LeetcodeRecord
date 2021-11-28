package contest.week269;

import java.util.*;

public class No4 {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ret = new LinkedList<>();
        HashSet<Integer> known = new HashSet<>();
        Arrays.sort(meetings, (int[] item1, int[] item2) -> {
            return item1[2] - item2[2];
        });
        known.add(0);
        known.add(firstPerson);
        for (int l = 0, r = 0; r < meetings.length; ) {
            // FIXME: Add an find Union here to detect the max capable here, fix this shit later
            boolean addAll = false;
            while (r < meetings.length && meetings[l][2] == meetings[r][2]) {
                r++;
            }

            for (int i = 0; i < r; i++) {
                if (known.contains(meetings[i][0]) || known.contains(meetings[i][1])) {
                    addAll = true;
                }
            }

            if (addAll) {
                for (int i = l; i < r; i++) {
                    known.add(meetings[i][0]);
                    known.add(meetings[i][1]);
                }
            }

            l = r;
        }

        Integer[] knownArray = known.toArray(new Integer[0]);
        for (int item : knownArray) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int[][] meetings1 = new int[][]{
                new int[]{0, 2, 1},
                new int[]{1, 3, 1},
                new int[]{4, 5, 1}
        };
        int firstPerson1 = 1;
        List<Integer> res1 = findAllPeople(n1, meetings1, firstPerson1);
        System.out.println("123");
    }
}
