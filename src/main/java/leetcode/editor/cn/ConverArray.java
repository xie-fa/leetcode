package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/1/1
 * 2022. 将一维数组转变成二维数组
 **/
public class ConverArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }

        int[][] ans = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ConverArray converArray = new ConverArray();
        int[][] array = converArray.construct2DArray(new int[]{1, 1, 1, 1}, 1, 4);
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
