package contest.week266;

import java.util.HashSet;
import java.util.Set;


// FIXME
public class No2 {
    public static long countVowels(String word) {
        Set<Character> theSet= new HashSet<>();
        theSet.add('a');
        theSet.add('e');
        theSet.add('i');
        theSet.add('o');
        theSet.add('u');
        long ret = 0;
        int n = word.length();
        for (int l = 0; l < n; l++) {
            long temp = 0;
            for (int r = l; r < n ; r++) {
                if (theSet.contains(word.charAt(r))) {
                    temp++;
                }
                ret += temp;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
    }
}
