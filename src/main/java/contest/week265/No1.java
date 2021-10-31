package contest.week265;

public class No1 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i % 10) {
                return i;
            }
        }
        return -1;
    }
}
