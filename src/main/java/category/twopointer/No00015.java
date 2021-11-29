package category.twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No00015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < nums.length && nums[left] == nums[left] - 1) {
                        left++;
                    }
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }

        return res;
    }
}
