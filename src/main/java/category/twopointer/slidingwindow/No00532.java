package category.twopointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class No00532 {
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> theMap = new HashMap<>();
        for (int num : nums) {
            theMap.put(num, theMap.getOrDefault(num, 0) + 1);
        }

        int ret = 0;
        for (int item : theMap.keySet()) {
            if (k == 0) {
                if (theMap.get(item) > 1) {
                    ret++;
                }
            } else {
                if (theMap.get(item + k) != null) {
                    ret++;
                }
            }
        }

        return ret;
    }
}
