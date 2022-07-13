package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class ExpandBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        dfs(root,list);
        int n = list.size();
        for(int i = 1 ; i < n;i++){
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

    private void dfs(TreeNode node, List<TreeNode> list) {

        if(node== null){
            return;
        }
        list.add(node);
        dfs(node.left,list);
        dfs(node.right,list);
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
