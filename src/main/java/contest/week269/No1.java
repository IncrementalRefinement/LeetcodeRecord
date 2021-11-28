package contest.week269;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No1 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}
