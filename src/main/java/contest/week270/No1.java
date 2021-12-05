package contest.week270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class No1 {

    public static int[] findEvenNumbers(int[] digits) {

        boolean[] isUsed = new boolean[digits.length];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            int res = 0;
            if ((digits[i] % 2) == 0) {
                isUsed[i] = true;
                res += digits[i];
                for (int j = 0; j < digits.length; j++) {
                    if (!isUsed[j]) {
                        res += digits[j] * 10;
                        isUsed[j] = true;
                        for (int k = 0; k < digits.length; k++) {
                            if (!isUsed[k]) {
                                if (digits[k] != 0) {
                                    arrayList.add(res + digits[k] * 100);
                                }
                            }
                        }
                        isUsed[j] = false;
                        res -= digits[j] * 10;
                    }
                }
                isUsed[i] = false;
            }
        }

        HashSet<Integer> theSet = new HashSet<>(arrayList);
        theSet.addAll(arrayList);
        Integer[] res = theSet.toArray(new Integer[0]);
        int[] realRes = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            realRes[i] = res[i];
        }
        Arrays.sort(realRes);
        return realRes;
    }

    public static void main(String[] args) {
        findEvenNumbers(new int[] {2,1,3,0});
    }
}
