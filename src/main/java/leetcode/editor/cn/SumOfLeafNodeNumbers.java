package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class SumOfLeafNodeNumbers {

    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode node, int x) {
        if(node == null ){
            return;
        }
        x = x*10+node.val;
        if(node.left == null && node.right == null){
            sum+=x;
            return;
        }
        dfs(node.left,x);
        dfs(node.right,x);
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
