package answers;

import java.util.HashSet;

public class No00575 {
    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> memo = new HashSet<>();
        int typeNum = 0;
        for (int type : candyType) {
            if (!memo.contains(type)) {
                memo.add(type);
                typeNum++;
            }
        }
        typeNum = Math.min(candyType.length / 2, typeNum);
        return typeNum;
    }
}
