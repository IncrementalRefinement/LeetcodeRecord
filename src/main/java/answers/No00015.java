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

    public static List<List<Integer>> threeSum(int[] nums) {
        final int n = 3;
        Arrays.sort(nums);
        return nSum(n, nums, 0, 0);
    }

    /*
    precondition: nums 升序排列
    返回 nums 中从 beginIndex 开始的子数组中的和为 target 的所有不重复的 n 个数的集合
     */
    private static List<List<Integer>> nSum(int n, int[] nums, int target, int beginIndex){
        // TODO: n == 1?
        List<List<Integer>> tempRes, currentRes = new LinkedList<>();
        for (int i = beginIndex; i < nums.length - n + 1;) {
            if (n == 3) {
                tempRes = twoSum(nums, target - nums[i], i + 1);
            } else {
                tempRes = nSum(n - 1, nums, target - nums[i], i + 1);
            }

            if (tempRes.size() != 0) {
                for (List<Integer> list : tempRes) {
                    list.add(nums[i]);
                }
                currentRes.addAll(tempRes);
                i++;
                while (i < nums.length - n + 1 && nums[i] == nums[i - 1]) {
                    i++;
                }
            } else {
                // TODO: 多走几步？
                i++;
            }
        }
        return currentRes;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int beginIndex) {
        List<List<Integer>> res = new LinkedList<>();
        int right = nums.length - 1;
        for (int left = beginIndex; left < nums.length - 1 && left < right;) {
            if (nums[left] + nums[right] == target) {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++; right--;
                while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        var res = threeSum(nums);
        System.out.println(res.size());
    }
}
