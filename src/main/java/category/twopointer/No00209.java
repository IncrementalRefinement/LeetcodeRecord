package category.twopointer;

public class No00209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int currentSum = 0;
        int ret = 0;

        while (r <= nums.length) {
            if (r == nums.length && currentSum < target) {
                break;
            }
            if (currentSum >= target) {
                if (ret == 0) {
                    ret = r - l;
                } else {
                    ret = Math.min(ret, r - l);
                }
                currentSum -= nums[l];
                l++;
            } else {
                currentSum += nums[r];
                r++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
