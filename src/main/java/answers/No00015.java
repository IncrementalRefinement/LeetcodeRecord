package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No00015 {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        final int target = 0;
//        List<List<Integer>> res = new LinkedList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            int currentSum = nums[i];
//            int right = nums.length - 1;
//            for (int left = i + 1; left < right;) {
//                if (currentSum + nums[left] + nums[right] == target) {
//                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
//                    res.add(temp);
//                    left++;
//                    right--;
//                    while(left < right && nums[left] == nums[left - 1]) left++;
//                } else if (currentSum + nums[left] + nums[right] < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return res;
//    }

    // TODO: finish framework
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

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        var res = threeSum(nums);
        System.out.println(res.size());
    }
}
