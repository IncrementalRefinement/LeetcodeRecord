package catagory.twopointer;

public class No00080 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0, current = 0;
        while (r < len) {
            while (r < len && nums[r] == nums[l]) {
                r++;
            }
            if (r - l > 2) {
                nums[current] = nums[l];
                current++;
                nums[current] = nums[l];
                current++;
            } else {
                for (int i = 0; i < r - l; i++) {
                    nums[current] = nums[l];
                    current++;
                }
            }
            l = r;
        }
        return current;
    }
}
