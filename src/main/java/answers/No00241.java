package answers;

import java.util.LinkedList;
import java.util.List;

public class No00241 {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();

        // TODO: helper(String expression, int begin, int end) save overhead of String copys
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' ||
                expression.charAt(i) == '-' ||
                expression.charAt(i) == '*') {
                    String left = expression.substring(0, i);
                    String right = expression.substring(i + 1);
                    List<Integer> leftResults= diffWaysToCompute(left);
                    List<Integer> rightResults = diffWaysToCompute(right);

                    for (int leftResult : leftResults) {
                        for (int rightResult : rightResults) {
                            switch (expression.charAt(i)) {
                                case '+' -> res.add(leftResult + rightResult);
                                case '-' -> res.add(leftResult - rightResult);
                                case '*' -> res.add(leftResult * rightResult);
                                default -> {
                                }
                            }
                        }
                    }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }

        return res;
    }
}
