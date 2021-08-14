package answers;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class No00145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        // TODO: fix endless issue
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    res.add(cur.val);
                    stack.pop();
                    cur = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
             1
              \
              2
             /
            3
            PREORDER: 1 2 3
            INORDER: 1 3 2
            POSTORDER: 3 2 1
        */
        TreeNode Node3 = new TreeNode(3);
        TreeNode Node2 = new TreeNode(2);
        TreeNode Node1 = new TreeNode(1);
        Node1.right = Node2;
        Node2.left = Node3;
        List<Integer> res = postorderTraversal(Node1);
        System.out.println("Postorder res:");
        for (Integer item : res) {
            System.out.println(item);
        }
    }
}
