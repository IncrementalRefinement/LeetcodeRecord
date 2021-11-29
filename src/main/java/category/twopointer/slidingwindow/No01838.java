package category.twopointer.slidingwindow;

import java.util.Arrays;

// TODO: fix this shit
public class No01838 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int current = nums[r];
        int currentSum = 0;
        int ret = 0;

        while (r < nums.length) {
            currentSum += (r - l) * (nums[r] - current);
            current = nums[r];
            r++;
            if (currentSum <= k) {
                if (r - l > ret) {
                    ret = r - l;
                }
            } else {
                while (currentSum > k) {
                    currentSum -= (current - nums[l]);
                    l++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int res1 = maxFrequency(new int[]{1,2,4}, 5);
        System.out.println(res1);
    }
}