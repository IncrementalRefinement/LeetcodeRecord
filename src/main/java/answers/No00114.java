package answers;

import util.TreeNode;

public class No00114 {
    public static void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode concatenatePoint = next;
                while (concatenatePoint.right != null) {
                    concatenatePoint = concatenatePoint.right;
                }
                concatenatePoint.right = cur.right;
                cur.right = next;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
