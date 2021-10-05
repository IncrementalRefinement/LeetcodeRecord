package answers;

public class No1004 {

    public static int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int l = 0, r = 0, max = 0, currentZeros = 0;

        while (r <= nums.length) {
            if (currentZeros > k) {
                while (l < r && nums[l] == 1) {
                    l++;
                }
                l++;
                currentZeros--;
            } else {
                if (r - l > max) max = r - l;
                r++;
                if (r <= nums.length && nums[r - 1] == 0) currentZeros++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
