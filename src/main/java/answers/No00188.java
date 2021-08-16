package answers;
/*
留一点笔记在这里:
1. 动态规划的核心是已知初始状态，可以由一个较小规模的状态推出较大问题的状态，并不断重复这个过程
2. 所以最关键的一点就是找出描述一个状态的所有描述变量，并且满足"最小原则"(我瞎取的)，什么是最小原则呢？
    a. 这些变量可以描述出这个状态，到由最后最终的规模的状态变量可以推得所需要的解答
    b. 可以由前面的状态变量推导出下一个状态的变量
    c. 这些描述变量可以体现为一个dp数组(可能是多维)的下标以及数组的值
   那么如何获取这些变量呢？
    我猜测其实根据问题大致就能感觉出来，比如这个股票问题中的天数、交易次数、是否持有股票、收益。根据自己对问题的理解多想一下就可以了，
    按照这种分析问题的方法，其实做到这一步，确定状态变量的同时也就确定了转移方程
3. 又因为是一个迭代的过程，所以如果我们只需要一个最终的状态变量，以及迭代过程中只需要部分小问题的状态变量，我们也就可以进行所谓的"状态压缩"
 */
public class No00188 {
    public static int maxProfit(int k, int[] prices) {
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

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(k, prices));
        prices = new int[]{1, 2, 4};
        System.out.println(maxProfit(k, prices));
    }
}
