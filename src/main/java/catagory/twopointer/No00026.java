package catagory.twopointer;

public class No00026 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 1,}));
        System.out.println(removeDuplicates(new int[] {1, 1, 2, 2}));
    }
}
