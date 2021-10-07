package answers;

public class No00424 {
    public static int characterReplacement(String s, int k) {
        int max = 0;
        int[] nums = new int[26];

        int l, r;

        for (l = 0, r = 0; r < s.length();) {
            int rCharIndex = s.charAt(r) - 'A';
            nums[rCharIndex]++;
            max = Math.max(nums[rCharIndex], max);
            if (r - l - max + 1 > k) {
                nums[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }

        return r - l;
    }
}
