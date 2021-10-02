package answers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No00241 {
    private static Map<Integer, Map<Integer, List<Integer>>> cache;

    public static List<Integer> diffWaysToCompute(String expression) {
        cache = new HashMap<>();
        return helper(expression, 0, expression.length());
    }

    private static List<Integer> helper(String expression, int begin, int end) {
        if (cache.get(begin) != null && cache.get(begin).get(end) != null) {
            return cache.get(begin).get(end);
        }

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


        if (cache.get(begin) != null) {
            cache.get(begin).put(end, res);
        } else {
            HashMap<Integer, List<Integer>> newMap = new HashMap<>();
            newMap.put(end, res);
            cache.put(begin, newMap);
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
