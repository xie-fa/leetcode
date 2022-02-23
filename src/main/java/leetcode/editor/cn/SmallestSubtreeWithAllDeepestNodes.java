package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 865 具有所有最深节点的最小子树
 *
 * @author 11757
 * @date 2022/1/21
 **/
public class SmallestSubtreeWithAllDeepestNodes {

    Map<TreeNode, Integer> depthMap;
    int max_depth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depthMap = new HashMap<>();
        depthMap.put(null, -1);
        dfs(root, null);

        for (Integer d : depthMap.values()) {
            max_depth = Math.max(max_depth,d);
        }
        return answer(root);
    }

    private TreeNode answer(TreeNode node) {
        if(node ==null||depthMap.get(node) == max_depth){
            return node;
        }
        TreeNode l = answer(node.left);
        TreeNode r = answer(node.right);
        if(l != null && r != null){
            return node;
        }
        if(l!=null){
            return l;
        }
        if(r!=null){
            return r;
        }
        return null;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depthMap.put(node, depthMap.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
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
