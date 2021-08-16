package answers;

import java.util.Arrays;

public class No00001 {
    public static int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0, right = nums.length - 1;
        int sum = sortedNums[left] + sortedNums[right];
        while (left < right) {
            if (sum < target) left++;
            else if (sum > target) right--;
            else {
                int index1 = -1, index2 = -1;
                int num1 = sortedNums[left], num2 = sortedNums[right];
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == num1) {
                        index1 = i;
                        break;
                    }
                }
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] == num2) {
                        index2 = i;
                        break;
                    }
                }
                return new int[] {index1, index2};
            }
            sum = sortedNums[left] + sortedNums[right];
        }
        return null;
    }
}
