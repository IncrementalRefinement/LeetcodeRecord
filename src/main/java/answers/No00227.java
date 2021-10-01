package answers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No00227 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0;
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        Stack<Integer> resStack = new Stack<>();


        for (int i = 0; i < s.length(); ) {
            char theChar = s.charAt(i);
            if (theChar >= '0' && theChar <= '9') {
                int currentNum = 0;
                while (theChar >= '0' && theChar <= '9') {
                    currentNum *= 10;
                    currentNum += theChar - '0';
                    i++;
                    if (i >= s.length()) break;
                    theChar = s.charAt(i);
                }
                nums.addLast(currentNum);
            } else if (theChar != ' '){
                ops.addLast(theChar);
                i++;
            } else {
                i++;
            }
        }

        resStack.push(nums.pollFirst());

        for (char op : ops) {
            switch(op) {
                case '+':
                    resStack.push(nums.pollFirst());
                    break;
                case '-':
                    resStack.push(-nums.pollFirst());
                    break;
                case '*':
                    resStack.push(resStack.pop() * nums.pollFirst());
                    break;
                case '/':
                    resStack.push(resStack.pop() / nums.pollFirst());
                    break;
                default:
                    break;
            }
        }

        for (int item : resStack) {
            res += item;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate(" 3/  2"));
    }
}