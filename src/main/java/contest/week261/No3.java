package contest.week261;

public class No3 {
    private static int mod = 3;
    // TODO
    public boolean stoneGameIX(int[] stones) {
        int x = 0, y = 0, z = 0;

        for (int stone : stones) {
            switch (stone % 3) {
                case 0 -> x++;
                case 1 -> y++;
                default -> z++;
            }
        }

        boolean[][][][] dp = new boolean[x][y][z][3];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    helper(i, j, k, dp);
                }
            }
        }

        return dp[x - 1][y - 1][z - 1][0];
    }

    private static void helper(int i, int j, int k, boolean[][][][] dp) {
        if (i >= dp.length || j >= dp[0].length || k >= dp[0][0].length) {
            return;
        }

        if (i + 1 < dp.length) {
            for (int xx = 0; xx < mod; xx++) {
                dp[i + 1][j][k][mod] = !dp[i][j][k][mod];
            }
        }

        if (j + 1 < dp[0].length) {
//            boolean cond1 = dp[i][j - 1][k];
//            boolean cond2 = dp[i - 1][j + 1][k];
        }

        if (k + 1 < dp[0][0].length) {
//            dp[i][j][k + 1] =
        }
    }
}
