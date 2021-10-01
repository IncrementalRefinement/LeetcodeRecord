package answers;

import java.util.Stack;

public class No00224 {
    public static int calculate(String s) {
        int sign = 1;
        int res = 0;
        Stack<Integer> signs = new Stack<>();
        signs.push(sign);

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else if (s.charAt(i) == '+') {
                sign = signs.peek();
            } else if (s.charAt(i) == '-') {
                sign = -signs.peek();
            } else if (s.charAt(i) == '(') {
                signs.push(sign);
            } else if (s.charAt(i) == ')') {
                signs.pop();
                sign = signs.peek();
            } else {
                int currentNum = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
                    currentNum = currentNum * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * currentNum;
                continue;
            }

            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1    + 1"));
        System.out.println(calculate("-1 + 2 - (-3 + 4)"));
    }
}
