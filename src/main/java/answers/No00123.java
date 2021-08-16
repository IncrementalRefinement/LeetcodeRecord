package answers;
public class No00123 {
    public static int maxProfit(int[] prices) {
        int k = 2;
        if (prices == null || prices.length == 0) return 0;
        int[][] prevState= new int[k + 1][2], currentState = new int[k + 1][2];
        prevState[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= i && j <= k; j++) {
                // i 天数， j 交易次数
                if (j == 0) {
                    currentState[j][0] = 0;
                } else {
                    if (j <= i - 1) {
                        currentState[j][0] = Math.max(prevState[j - 1][1] + prices[i], prevState[j][0]);
                    } else {
                        currentState[j][0] = prevState[j - 1][1] + prices[i];
                    }
                }
                if (j <= i - 1) {
                    currentState[j][1] = Math.max(prevState[j][0] - prices[i], prevState[j][1]);
                } else {
                    currentState[j][1] = prevState[j][0] - prices[i];
                }
            }
            prevState = currentState;
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            if (currentState[i][0] > res) res = currentState[i][0];
        }
        return res;
    }
}
