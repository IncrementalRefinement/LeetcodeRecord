package contest.week266;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// TODO: this solution is to verbose, FIX this SHIT
public class No1 {
    public static int countVowelSubstrings(String word) {
        int ret = 0;
        Set<Character> theSet= new HashSet<>();
        theSet.add('a');
        theSet.add('e');
        theSet.add('i');
        theSet.add('o');
        theSet.add('u');
        int l = 0, r = 0;
        while (r < word.length()) {
            if (!theSet.contains(word.charAt(r))) {
                r++;
            } else {
                while (r < word.length() && theSet.contains(word.charAt(r))) {
                    r++;
                }
                ret += helper(word, l, r);
            }
            l = r;
        }

        return ret;
    }

    private static int helper(String word, int lBound, int rBound) {
        if (rBound - lBound < 5) {
            return 0;
        }
        int ret = 0;
        Map<Character, Integer> numMap = new HashMap<>();
        numMap.put('a', 0);
        numMap.put('e', 0);
        numMap.put('i', 0);
        numMap.put('o', 0);
        numMap.put('u', 0);
        int l = lBound, r = lBound;
        while (l <= rBound - 5) {
            while (r < rBound && !isSatisfied(numMap)) {
                numMap.put(word.charAt(r), numMap.get(word.charAt(r)) + 1);
                r++;
            }
            if (!isSatisfied(numMap)) {
                break;
            } else {
                ret += rBound - r + 1;
            }
            numMap.put(word.charAt(l), numMap.get(word.charAt(l)) - 1);
            l++;
        }
        return ret;
    }

    private static boolean isSatisfied(Map<Character, Integer> numMap) {
        return numMap.get('a') > 0 && numMap.get('e') > 0 && numMap.get('i')  > 0 && numMap.get('o') > 0 && numMap.get('u') > 0;
    }

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("duuebuaeeeeeeuaoeiueaoui"));

    }
}
