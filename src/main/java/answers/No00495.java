package answers;

public class No00495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = timeSeries.length * duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] < duration) {
                ret -= duration - (timeSeries[i + 1] - timeSeries[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1,2}, 2));
        // System.out.println(findPoisonedDuration());
    }
}
