package contest.week268;

public class No1 {
    public static int maxDistance(int[] colors) {
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[j] != colors[i]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
