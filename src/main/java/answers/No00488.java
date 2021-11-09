package answers;

import java.util.*;

public class No00488 {

    private static Map<String, Integer> memo = new HashMap<>();

    public static int findMinStep(String board, String hand) {
        char[] handCharArray = hand.toCharArray();
        Arrays.sort(handCharArray);
        hand = String.valueOf(handCharArray);
        // memo.put(board + '#' + hand, Integer.MAX_VALUE);
        String key = board + '#' + hand;
        dfs(board, hand);
        int ret = memo.get(key);
        if (ret == Integer.MAX_VALUE) {
            return -1;
        } else {
            return memo.get(key);
        }
    }

    private static int dfs(String board, String hand) {
        if (hand.length() == 0) {
            return Integer.MAX_VALUE;
        }
        int ret;
        String key = board + '#' + hand;
        if (memo.containsKey(key)) {
            return memo.get(key);
        } else {
            ret = Integer.MAX_VALUE;
        }
        for (int i = 0; i < board.length(); i++) {
            for (int j = 0; j < hand.length(); j++) {
                String newBoard = removeConsecutive(board.substring(0, i) + hand.charAt(j) + board.substring(i));
                if (newBoard.length() == 0) {
                    memo.put(key, 1);
                    return 1;
                } else {
                    int tempRet =  dfs(newBoard, hand.substring(0, j) + hand.substring(j + 1));
                    if (tempRet < Integer.MAX_VALUE) {
                        ret = Math.min(ret, tempRet + 1);
                    }
                }
            }
        }
        memo.put(key, ret);
        return ret;
    }

    private static String removeConsecutive(String board) {
//        if (board.equals("RRRRRR")) System.out.println("OKK");
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
