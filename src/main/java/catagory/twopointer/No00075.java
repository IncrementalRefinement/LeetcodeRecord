package catagory.twopointer;

public class No00075 {
    public static void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                mid++;
                left++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
