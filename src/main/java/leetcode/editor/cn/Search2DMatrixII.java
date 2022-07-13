package leetcode.editor.cn;


/**
 * @author 11757
 * @date 2022/3/15
 **/
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] row : matrix) {
            if (search(row, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean zSearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                --y;
            }else {
                ++x;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
