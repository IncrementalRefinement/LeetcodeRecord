package answers;

import java.util.HashMap;
import java.util.Map;

public class No00299 {

    public static String getHint(String secret, String guess) {
        Map<Character, Integer> theMap = new HashMap<>();
        int n = secret.length();
        for (int i = 0; i < n; i++) {
            Character theChar = secret.charAt(i);
            if (theMap.get(theChar) == null) {
                theMap.put(theChar, 1);
            } else {
                theMap.put(theChar, theMap.get(theChar) + 1);
            }
        }
        int bullNum = 0, cowNum = 0, total = 0;

        for (int i = 0; i < n; i++) {
            Character guessChar = guess.charAt(i);
            Character secretChar = secret.charAt(i);
            if (guessChar == secretChar) {
                total++;
                bullNum++;
                theMap.put(guessChar, theMap.get(guessChar) - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            Character guessChar = guess.charAt(i);
            Character secretChar = secret.charAt(i);
            if (secretChar != guessChar && theMap.containsKey(guessChar) && theMap.get(guessChar) > 0) {
                total++;
                theMap.put(guessChar, theMap.get(guessChar) - 1);
            }
        }

        cowNum = total - bullNum;

        return bullNum + "A" + cowNum + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1122", "1222"));
    }
}
