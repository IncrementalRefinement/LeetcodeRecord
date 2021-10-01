package answers;

import java.util.Stack;

public class No00227 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0, currentNum = 0;
        int preSign = '+';
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char theChar = s.charAt(i);
            if (isDigit(theChar)) {
                currentNum = currentNum * 10 + theChar - '0';
            }

            if ((!isDigit(theChar) && theChar != ' ') || i + 1 == s.length()) {
                switch (preSign) {
                    // TODO: NB
                    case '+' -> nums.push(currentNum);
                    case '-' -> nums.push(-currentNum);
                    case '*' -> nums.push(nums.pop() * currentNum);
                    case '/' -> nums.push(nums.pop() / currentNum);
                    default -> {
                    }
                }
                currentNum = 0;
                preSign = theChar;
            }
        }


        while (!nums.isEmpty()) {
            res += nums.pop();
        }

        return res;
    }


    private static boolean isDigit(char theChar) {
        return theChar >= '0' && theChar <= '9';
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate(" 3/  2"));
    }
}