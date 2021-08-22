package answers;

public class No00005 {
    public static String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int longestLen = 0;
        int beginIndex = 0, endIndex = 0;
        char[] charArray = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (helper(charArray, isPalindrome, i, j)) {
                    if (j - i + 1> longestLen) {
                        longestLen = j - i + 1;
                        beginIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        if (longestLen == 0) {
            return String.valueOf(charArray[0]);
        } else {
            return s.substring(beginIndex, endIndex + 1);
        }
    }

    private static boolean helper(char[] charArray, boolean[][] isPalindrome, int i, int j) {
        // i > j
        boolean res;
        if (i + 1 == j) {
            res = charArray[i] == charArray[j];
        } else {
            res = charArray[i] == charArray[j] && isPalindrome[i + 1][j - 1];
        }
        isPalindrome[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aaaa"));
    }
}
