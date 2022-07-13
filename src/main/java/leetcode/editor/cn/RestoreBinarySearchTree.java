package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/10
 **/
public class RestoreBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void recover(TreeNode node, int count, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.val == x || node.val == y) {
            node.val = node.val == x ? y : x;
            if (--count == 0) {
                return;
            }
        }

        recover(node.right, count, x, y);
        recover(node.left, count, x, y);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    private void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
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
