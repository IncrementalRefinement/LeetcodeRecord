package answers;

import java.util.*;

public class No002019 {

    private final static int TRUE_ANSWER_SCORE = 5;
    private final static int PARTIAL_TRUE_ANSWER_SCORE = 2;
    private static Set<Integer>[][] cache;

    public static int scoreOfStudents(String s, int[] answers) {
        if (answers == null || s == null)  return 0;

        // TODO: how Java generic works?
        // cache = (Set<Integer>[][]) new Object[s.length() / 2 + 1][s.length() / 2 + 1];
         cache = new Set[s.length() / 2 + 1][s.length() / 2 + 1];
        int res = 0;
        int trueResult = calcTrueResult(s);
        Set<Integer> possibleResults = calcPossibleResult(s);

        for (int answer : answers) {
            if (answer == trueResult) {
                res += TRUE_ANSWER_SCORE;
            } else if (possibleResults.contains(answer)) {
                res += PARTIAL_TRUE_ANSWER_SCORE;
            }
        }

        cache = null;
        return res;
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
        Set<Integer> possibleResults;
        Set<Integer> possibleLeftResults;
        Set<Integer> possibleRightResults;

        for (int i = 0; i < cache.length; i++) {
            cache[i][i] = new HashSet<>();
            cache[i][i].add(s.charAt(i * 2) - '0');
        }

        for (int step = 1; step < cache.length; step++) {
            for (int begin = 0; begin < cache.length - step; begin++) {
                int end = begin + step;
                cache[begin][end] = new HashSet<>();
                for (int i = begin; i < end; i++) {
                    possibleLeftResults = cache[begin][i];
                    possibleRightResults = cache[i + 1][end];
                    for (int left : possibleLeftResults) {
                        for (int right : possibleRightResults) {
                            switch (s.charAt(i * 2 + 1)) {
                                case '+' -> {if (left + right <= 1000) cache[begin][end].add(left + right);}
                                case '*' -> {if (left * right <= 1000) cache[begin][end].add(left * right);}
                                default -> {}
                            }
                        }
                    }
                }
            }
        }

        possibleResults = cache[0][cache.length - 1];
        return  possibleResults;
    }

    public static void main(String[] args) {
        /**
         * "7+3*1*2"
         * [20,13,42]
         */
        int res = scoreOfStudents("1+2*3+4", new int[] {13, 21, 11, 15});
        System.out.println(res);
    }
}
