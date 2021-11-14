package contest.week267;

public class No1 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    res++;
                    tickets[i]--;
                }
                if (i == k && tickets[k] == 0) {
                    break;
                }
            }
        }
        return res;
    }
}
