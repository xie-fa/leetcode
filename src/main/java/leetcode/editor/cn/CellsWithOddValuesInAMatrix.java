package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/7/12
 **/
public class CellsWithOddValuesInAMatrix {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] odd = new int[m][n];
        for (int[] a : indices) {
            int x = a[0];
            int y = a[1];
            for (int i = 0; i < n; i++) {
                odd[x][i] += 1;
            }
            for (int i = 0; i < m; i++) {
                odd[i][y] += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(odd[i][j]%2==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CellsWithOddValuesInAMatrix cells = new CellsWithOddValuesInAMatrix();
        int[][] ints = new int[][]{{0,1},{1,1}};
        System.out.println(cells.oddCells(2,3,ints));
    }
}
