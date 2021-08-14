package answers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No00039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new LinkedList<>();
        helper(candidates, 0, temp, res, target);
        return res;
    }

    private static void helper(int[] candidates, int index, List<Integer> temp, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(temp));
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, i, temp, res, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidate = {2, 3, 5};
        int target = 8;
        List<List<Integer>> res = new LinkedList<>();
        res = combinationSum(candidate, target);
        for (List<Integer> list : res) {
            StringBuffer sb = new StringBuffer();
            for (Integer item : list) {
                sb.append(item);
                sb.append(", ");
            }
            if (sb.length() >= 3) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }
        }
    }
}
