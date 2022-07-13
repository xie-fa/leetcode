package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class PathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int sum = 0;
        return dfs(root, sum, targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);

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
