package answers;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class No00094 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                res.add(cur.val);

            }
        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // do it iteratively
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
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
        List<Integer> res = inorderTraversal(Node1);
        System.out.println("Inorder res:");
        for (Integer item : res) {
            System.out.println(item);
        }
    }
}
