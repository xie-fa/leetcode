package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class VerifyBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return traverse(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean traverse(TreeNode node,long lower,long upper){
        if(node == null){
            return true;
        }

        if(node.val <= lower || node.val >= upper){
            return false;
        }
        return traverse(node.left,lower,node.val)&&traverse(node.right,node.val,upper);

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
