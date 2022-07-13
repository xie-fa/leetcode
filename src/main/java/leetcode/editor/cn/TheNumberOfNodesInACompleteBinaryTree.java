package leetcode.editor.cn;

/**
 * 完全二叉树的节点个数
 *
 * @author 11757
 * @date 2022/3/15
 **/
public class TheNumberOfNodesInACompleteBinaryTree {


    int cnt = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return cnt;
    }

    private void dfs(TreeNode node) {
        if(node==null){
            return;
        }
        cnt++;
        dfs(node.left);
        dfs(node.right);
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
