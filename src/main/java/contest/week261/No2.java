package contest.week261;

import java.util.Arrays;

public class No2 {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        if (rolls == null || n == 0) return new int[0];
        int total = (rolls.length + n) * mean;
        int currentSum = Arrays.stream(rolls).sum();
        int delta = total - currentSum;
        int average = delta / n;
        if (average == 0) return new int[0];
        int mod = delta % (n * average);

        if (average > 6 || delta < 0 || (average == 6 && mod != 0)) {
            return new int[0];
        }

        int[] result = new int[n];

        for (int i = 0; i < mod; i++) {
            result[i] = (average + 1);
        }

        for (int i = mod; i < result.length; i++) {
            result[i] = average;
        }

        return result;
    }

    /**
     [4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3]
     2
     53
     */
    public static void main(String[] args) {

        printIntArray(missingRolls(new int[] {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}
, 2, 53));
    }

    private static void printIntArray(int[] intArray) {
        for (int item : intArray) {
            System.out.println(item);
        }
    }
}
