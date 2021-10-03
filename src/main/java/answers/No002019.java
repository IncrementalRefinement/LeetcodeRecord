package answers;

import java.util.*;

public class No002019 {

    private final static int TRUE_ANSWER_SCORE = 5;
    private final static int PARTIAL_TRUE_ANSWER_SCORE = 2;
    private static HashMap<String, Set<Integer>> cache;

    public static int scoreOfStudents(String s, int[] answers) {
        cache = new HashMap<>();
        if (answers == null || s == null)  return 0;

        int[] res = new int[answers.length];
        int trueResult = calcTrueResult(s);
        Set<Integer> possibleResults = calcPossibleResult(s);

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == trueResult) {
                res[i] = TRUE_ANSWER_SCORE;
            } else if (possibleResults.contains(answers[i])) {
                res[i] = PARTIAL_TRUE_ANSWER_SCORE;
            }
        }
        cache = null;
        return Arrays.stream(res).sum();
    }

    private static int calcTrueResult(String s) {
        int trueResult = 0;
        char preSign = '+';
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                preSign = '+';
            } else if (s.charAt(i) == '*'){
                preSign = '*';
            } else {
                switch (preSign) {
                    case '+' -> nums.push(s.charAt(i) - '0');
                    case '*' -> nums.push(nums.pop() * (s.charAt(i) - '0'));
                    default -> {}
                }
            }
        }

        while (!nums.isEmpty()) {
            trueResult += nums.pop();
        }

        return trueResult;
    }

    private static Set<Integer> calcPossibleResult(String s) {

        if (cache != null && cache.get(s) != null) {
            return cache.get(s);
        }

        Set<Integer> possibleResults = new HashSet<>();
        Set<Integer> possibleLeftResults;
        Set<Integer> possibleRightResults;

        if (s.length() == 1) {
            possibleResults.add(Integer.valueOf(s));
            return possibleResults;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i))) continue;
            possibleLeftResults = calcPossibleResult(s.substring(0, i));
            possibleRightResults = calcPossibleResult(s.substring(i + 1));
            for (int left : possibleLeftResults) {
                for (int right : possibleRightResults) {
                    switch (s.charAt(i)) {
                        case '+' -> possibleResults.add(left + right);
                        case '*' -> possibleResults.add(left * right);
                        default -> {}
                    }
                }
            }
        }

        if (cache != null) cache.put(s, possibleResults);

        return  possibleResults;
    }

    private static boolean isDigit(char theChar) {
        return theChar >= '0' && theChar <= '9';
    }

    public static void main(String[] args) {
        int res = scoreOfStudents("0*0+0+0+0*0", new int[] {20, 13, 42});
        System.out.println(res);
    }
}
