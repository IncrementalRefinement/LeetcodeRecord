package contest.week269;

public class No3 {
    public static int minimumDeletions(int[] nums) {
        int min = nums[0];
        int minIndex = 0;
        int max = nums[0];
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        if (minIndex == maxIndex) {
            return 1;
        }

        int leftleft = Math.max(minIndex, maxIndex) + 1;
        int leftright = Math.min(minIndex, maxIndex) + 1 + nums.length - Math.max(minIndex, maxIndex);
        int rightright = nums.length - Math.min(minIndex, maxIndex);
        return Math.min(leftleft, Math.min(leftright, rightright));
    }

    public static void main(String[] args) {
        // System.out.println(minimumDeletions(new int[] {2,10,7,5,4,1,8,6}));
        System.out.println(minimumDeletions(new int[] {100}));
    }
}
