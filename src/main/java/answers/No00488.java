package answers;

import java.util.*;

public class No00488 {

    private static Map<String, Integer> memo = new HashMap<>();

    public static int findMinStep(String board, String hand) {
        Map<Character, Integer> handNumMap = new HashMap<>();
        handNumMap.put('R', 0);
        handNumMap.put('Y', 0);
        handNumMap.put('B', 0);
        handNumMap.put('G', 0);
        handNumMap.put('W', 0);
        for (Character theChar : hand.toCharArray()) {
            handNumMap.put(theChar, handNumMap.get(theChar) + 1);
        }
        int totalHandNum = hand.length();
        int dfsRes = dfs(board, handNumMap, totalHandNum);
        if (dfsRes != Integer.MAX_VALUE) {
            return dfsRes;
        } else {
            return -1;
        }
    }

    private static int dfs(String board, Map<Character, Integer> handNumMap, int totalHandNum) {
        int res = Integer.MAX_VALUE;
        board = removeConsecutive(board);
        if (totalHandNum == 0 && board.length() != 0) {
            return res;
        } else if (board.length() == 0) {
            return 0;
        }
        char[] charArray = board.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (char theChar : handNumMap.keySet()) {
                if (handNumMap.get(theChar) > 0) {
                    handNumMap.put(theChar, handNumMap.get(theChar) - 1);
                    int tempRes = dfs(board.substring(0, i) + theChar + board.substring(i), handNumMap, totalHandNum - 1);
                    if (tempRes != Integer.MAX_VALUE) {
                        res = Math.min(res, tempRes + 1);
                    }
                    handNumMap.put(theChar, handNumMap.get(theChar) + 1);
                }
            }
        }
        return res;
    }

    private static String removeConsecutive(String board) {
        if (board.equals("RRRRRR")) System.out.println("OKK");
        int len = board.length();
        for (int i = 0; i < len - 2; i++) {
            for (int j = 1;; j++) {
                if (i + j >= len || board.charAt(i + j) != board.charAt(i)){
                    if (j > 2) {
                        board = board.substring(0, i) + board.substring(i + j);
                        i = -1;
                        len = board.length();
                    }
                    break;
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));   // 2
        System.out.println(findMinStep("RRWWRRBBRR", "WB"));    // 2
        System.out.println(findMinStep("BGGRRYY", "BBYRG"));    // 5
    }
}
