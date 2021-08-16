package answers;

public class No00121 {
    public static int maxProfit(int[] prices) {
        int todaySellProfit = 0, yesterdaySellProfit = 0, res = 0;
        for (int i = 1; i < prices.length; i++) {
            todaySellProfit = yesterdaySellProfit + (prices[i] - prices[i - 1]);
            if (todaySellProfit > 0) {
                if (todaySellProfit > res) res = todaySellProfit;
                yesterdaySellProfit = todaySellProfit;
            } else {
                yesterdaySellProfit = 0;
            }
        }
        return res;
    }
}
