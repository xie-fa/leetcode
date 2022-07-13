package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/14
 **/
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //查看所在行
        int high = 0;
        int low = m - 1;
        while (high <= low) {
            int mid = (high + low) / 2;
            if (matrix[mid][n - 1] > target) {
                low = mid - 1;
            } else if (matrix[mid][n - 1] < target){
                high = mid + 1;
            }else {
                return true;
            }
        }
        if(high >= m){
            return false;
        }

        //high对应的行则为target可能存在的行
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[high][mid] > target) {
                right = mid - 1;
            } else if (matrix[high][mid] < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        if(left >= n){
            return false;
        }
        return matrix[high][left] == target;
    }

    public static void main(String[] args) {
        SearchA2DMatrix dMatrix = new SearchA2DMatrix();
        int[][] x= new int[][]{{1,3,5}};
        System.out.println(dMatrix.searchMatrix(x,0));
    }
}
