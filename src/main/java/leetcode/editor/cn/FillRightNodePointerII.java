package leetcode.editor.cn;

import java.util.Queue;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class FillRightNodePointerII {


    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        Node cur = root;

        while (cur != null) {
            Node node = new Node(0);
            Node pre = node;
            while (cur != null) {
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = node.next;
        }
        return root;
    }

    void diffNodeNext(Node node, Node rootNext) {
        while (rootNext != null) {
            if (rootNext.left != null) {
                node.next = rootNext.left;
                return;
            } else if (rootNext.right != null) {
                node.next = rootNext.right;
                return;
            } else {
                rootNext = rootNext.next;
            }
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
