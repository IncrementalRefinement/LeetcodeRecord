package answers;

import java.util.ArrayList;
import java.util.List;

public class No00679 {

    private final static double DELTA = 0.01;
    private final static double TARGET = 24;
    private final static int ADD = 0;
    private final static int MINUS = 1;
    private final static int MULTIPLY = 2;
    private final static int DIVIDE = 3;
    private final static int START_OPTION = ADD;
    private final static int END_OPTION = DIVIDE;


    public static boolean judgePoint24(int[] cards) {
        if (cards == null || cards.length != 4) return false;
        List<Double> nums = new ArrayList<>();
        for (int item : cards) {
            nums.add((double) item);
        }
        return helper(nums);
    }

    private static boolean helper(List<Double> nums) {
        int n = nums.size();

        if (n == 1) {
            return (Math.abs(nums.get(0) - TARGET) < DELTA);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                List<Double> newNums = new ArrayList<>(n - 1);
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        newNums.add(nums.get(k));
                    }
                }
                for (int option = START_OPTION; option <= END_OPTION; option++) {
                    switch (option) {
                        case ADD -> {
                            if (i < j) {
                                newNums.add(nums.get(i) + nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        case MINUS -> {
                            newNums.add(nums.get(i) - nums.get(j));
                        }
                        case MULTIPLY -> {
                            if (i < j) {
                                newNums.add(nums.get(i) * nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        case DIVIDE -> {
                            if (Math.abs(nums.get(j)) < DELTA) continue;
                            newNums.add(nums.get(i) / nums.get(j));
                        }
                        default -> {}
                    }
                    if (helper(newNums)) return true;
                    newNums.remove(newNums.size() - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{1, 3, 4, 6}));
    }
}
