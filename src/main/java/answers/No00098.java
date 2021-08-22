package answers;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class No00098 {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ArrayList<Integer> inorderRes = inorderTraverse(root);
        for (int i = 0; i < inorderRes.size() - 1; i++) {
            if (inorderRes.get(i) >= inorderRes.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> inorderTraverse(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || stack.size() != 0) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        System.out.println(isValidBST(root));
    }
}
