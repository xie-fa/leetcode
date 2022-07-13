package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class PreorderTraversalOfNAryTree {

    public List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    public void dfs(Node node) {
        if(node == null){
            return;
        }
        ans.add(node.val);
        for (Node children : node.children) {
            dfs(children);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
