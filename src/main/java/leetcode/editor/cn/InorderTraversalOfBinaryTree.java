package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/10
 */
public class InorderTraversalOfBinaryTree {

    public List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
