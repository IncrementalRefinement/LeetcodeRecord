package catagory.twopointer;

public class No00283 {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                r++;
            } else {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
    }

    private static void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
