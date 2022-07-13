package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class PathSumII {

    public List<List<Integer>> ans = new ArrayList<>();
    public Stack<Integer> records = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        records.push(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                ans.add(new ArrayList<>(records));
            }
        }
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
        records.pop();
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
