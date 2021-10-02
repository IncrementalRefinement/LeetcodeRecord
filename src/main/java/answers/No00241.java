package answers;

import java.util.LinkedList;
import java.util.List;

public class No00241 {
    public static List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, 0, expression.length());
    }

    private static List<Integer> helper(String expression, int begin, int end) {
        List<Integer> res = new LinkedList<>();

        for (int i = begin; i < end; i++) {
            if (expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*') {
                List<Integer> leftResults= helper(expression, begin, i);
                List<Integer> rightResults = helper(expression, i + 1, end);

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
            res.add(Integer.valueOf(expression.substring(begin, end)));
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = diffWaysToCompute("2-1+1");
        for (var item : res) {
            System.out.println(item);
        }
    }
}
