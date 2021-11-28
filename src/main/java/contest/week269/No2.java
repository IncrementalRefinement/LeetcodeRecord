package contest.week269;

public class No2 {
    public static int[] getAverages(int[] nums, int k) {
        int[] ret = new int[nums.length];
        int len = nums.length;

        for (int i = 0; i < len && i < k; i++) {
            ret[i] = -1;
            ret[len - i - 1] = -1;
        }
        long currentSum = 0;

        if (2 * k >= len) {
            return ret;
        }

        for (int i = 0; i <= 2 * k; i++) {
            currentSum += nums[i];
        }

        ret[k] = (int) (currentSum / (2 * k + 1));

        for (int l = 1, r = 2 * k + 1, mid = k + 1; r < len; l++, r++, mid++) {
            currentSum -= nums[l - 1];
            currentSum += nums[r];
            ret[mid] = (int) (currentSum / (2 * k + 1));
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] res = getAverages(new int[] {7,4,3,9,1,8,5,2,6}, 3);
        System.out.println("123");
    }
}
