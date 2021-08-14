package answers;

import java.util.LinkedList;
import java.util.List;

public class No0022 {
    public static List<String> generateParenthesis(int n) {
        LinkedList<String> res  = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int left = 0, right = 0;
        backtrace(res, sb, left, right, n);
        return res;
    }

    private static void backtrace(LinkedList<String> res, StringBuffer sb, int left, int right, int max) {
        // illegal
        if (right > left || left > max) {
            return;
        }
        // backtrace end
        if (left == max && right == max) {
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        backtrace(res, sb, left + 1, right, max);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        backtrace(res, sb, left, right + 1, max);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).get(0));
    }
}
