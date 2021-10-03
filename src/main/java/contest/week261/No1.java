    package contest.week261;

    public class No1 {
        public static int minimumMoves(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            char[] charArray = s.toCharArray();
            int changeTime = 0;

            for (int i = 0; i < charArray.length;) {
                if (charArray[i] == 'X') {
                    int j = 0;
                    changeTime++;
                    while (j < 3 && i + j < charArray.length) {
                        charArray[i + j] = 'O';
                        j++;
                    }
                    i += j;
                } else {
                    i++;
                }
            }

            return changeTime;
        }

        public static void main(String[] args) {
            System.out.println(minimumMoves("XXOX"));
            System.out.println(minimumMoves("XXX"));
            System.out.println(minimumMoves(""));
            System.out.println(minimumMoves("XXXX"));
        }
    }
