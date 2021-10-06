package answers;

public class No02024 {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || k < 0) return 0;

        int TNum = 0, FNum = 0, res = 0;

        for (int l = 0, r = 0; r < answerKey.length();) {
            if (answerKey.charAt(r) == 'T') {
                TNum++;
            } else {
                FNum++;
            }

            while (TNum > k && FNum > k) {
                if (answerKey.charAt(l) == 'T') {
                    TNum--;
                } else {
                    FNum--;
                }
                l++;
            }
            res =  Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers("F", 1));
    }
}
