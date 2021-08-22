package answers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No00017 {
    private static final HashMap<Integer, char[]> num2Chararray = new HashMap<>();

    static {
        num2Chararray.put(2, "abc".toCharArray());
        num2Chararray.put(3, "def".toCharArray());
        num2Chararray.put(4, "ghi".toCharArray());
        num2Chararray.put(5, "jkl".toCharArray());
        num2Chararray.put(6, "mno".toCharArray());
        num2Chararray.put(7, "pqrs".toCharArray());
        num2Chararray.put(8, "tuv".toCharArray());
        num2Chararray.put(9, "wxyz".toCharArray());

    }

    public static List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();
        List<String> res = new LinkedList<>();
        Integer[] integers = new Integer[digits.length()];
        for (int i = 0; i < charArray.length; i++) {
            integers[i] = charArray[i] - '0';
        }
        for (Integer integer : integers) {
            customizeMultiple(res, num2Chararray.get(integer));
        }
        return res;
    }

    private static void customizeMultiple(List<String> list, char[] charArray) {
        LinkedList<StringBuilder> sbList = new LinkedList<>();
        if (list.size() == 0) {
            for (char item : charArray) {
                list.add(String.valueOf(item));
            }
            return;
        }

        for (String string : list) {
            for (char item : charArray) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(item);
                sbList.add(sb);
            }
        }

        list.clear();
        for (StringBuilder sb : sbList) {
            list.add(sb.toString());
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        for (String string : res) {
            System.out.println(string);
        }
    }
}
