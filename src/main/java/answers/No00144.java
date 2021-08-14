package answers;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class No00144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                stack.push(cur.right);
                stack.push(cur.left);
                res.add(cur.val);
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
        List<Integer> res = preorderTraversal(Node1);
        System.out.println("Preorder res:");
        for (Integer item : res) {
            System.out.println(item);
        }
    }
}
