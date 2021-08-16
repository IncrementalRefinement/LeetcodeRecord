package answers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No00015 {
    // TODO: complete framework
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        nSum(3, nums, 0, 0, res);
        return res;
    }

    private static void nSum(int n, int[] nums, int target, int beginIndex, List<List<Integer>> res) {
        if (n == 2) {
            twoSum(nums, target, beginIndex, res);
        } else {
            for (int i = beginIndex; i < nums.length; i++) {
                nSum(n - 1, nums, target - nums[i], i + 1, res);
            }
        }
    }

    private static void twoSum(int[] nums, int target, int beginIndex, List<List<Integer>> res) {

    }
}
