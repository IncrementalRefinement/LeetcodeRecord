package answers;

import java.util.ArrayList;
import java.util.Arrays;

public class No00406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });
        ArrayList<Integer> indexes = new ArrayList<>();
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            indexes.add(i);
        }
        for (int[] thePeople : people) {
            int index = indexes.remove(thePeople[1]);
            res[index] = thePeople;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for (int[] item : res) {
            System.out.println(item[0] + ", " + item[1]);
        }
    }
}
