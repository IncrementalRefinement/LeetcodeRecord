package answers;

public class No00122 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int upAmount = prices[i + 1] - prices[i];
            if (upAmount > 0) res += upAmount;
        }
        return res;
    }
}
