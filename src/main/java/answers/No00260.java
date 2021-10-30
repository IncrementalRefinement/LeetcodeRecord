package answers;

public class No00260 {
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int allXor = 0;

        for (int num : nums) {
            allXor ^= num;
        }

        int x1 = 0, x2 = 0;
        int mask = 1;
        while ((mask & allXor) == 0) {
            mask = mask << 1;
        }

        for (int num : nums) {
            if ((num & mask) == 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }

        res[0] = x1;
        res[1] = x2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1, 2, 1, 3, 2, 5}));
    }
}
