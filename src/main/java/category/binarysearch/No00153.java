package category.binarysearch;

public class No00153 {
    public static int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int index = -1;
        while (l <= r)  {
            int m = (l + r) / 2;
            if (nums[m] - nums[len - 1] > 0) {
                l = m + 1;
            } else {
                if (nums[m] <= nums[(m + 1) % len] && nums[m] <= nums[(m - 1 + len) % len]) {
                    index = m;
                    break;
                } else {
                    r = m - 1;
                }
            }
        }
        return nums[index];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
    }
}
