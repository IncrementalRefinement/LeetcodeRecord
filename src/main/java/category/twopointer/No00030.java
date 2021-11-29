package category.twopointer;

import java.util.*;

// 1. N  * (S / N)
// 2. S * (words.length())
public class No00030 {
    public static List<Integer> findSubstring(String s, String[] words) {
        int wordNum  = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> table = new HashMap<>();
        List<Integer> res = new LinkedList<>();

        for (String word : words) {
            table.put(word, table.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            int l = i;
            int r = i;
            Map<String, Integer> currentTable = new HashMap<>();
            while (r < s.length()) {
                String currentStr = s.substring(r, Math.min(r + wordLen, s.length()));
                if (table.get(currentStr) == null) {
                    currentTable.clear();
                    r += wordLen;
                    l = r;
                    count = 0;
                } else if (currentTable.getOrDefault(currentStr, 0) < table.get(currentStr)) {
                    count++;
                    r += wordLen;
                    currentTable.put(currentStr, currentTable.getOrDefault(currentStr, 0) + 1);
                } else if (Objects.equals(currentTable.get(currentStr), table.get(currentStr))) {
                    count--;
                    currentTable.put(s.substring(l, l+ wordLen), currentTable.get(s.substring(l, l+ wordLen)) - 1);
                    l += wordLen;
                }

                if (count == wordNum) {
                    res.add(l);
                    count--;
                    currentTable.put(s.substring(l, l+ wordLen), currentTable.get(s.substring(l, l+ wordLen)) - 1);
                    l += wordLen;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"}).size());
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}).size());
    }
}
