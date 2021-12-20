package leetcode.editor.cn;

/**
 * 375 猜数字大小
 *
 * @author xiefa
 **/
public class GuessNumSize {


    public int getMoneyAmount(int n) {

        int[][] f = new int[n + 1][n + 1];
//        for (int i = 0; i < f.length; i++) {
//            for (int j = 0; j < f[i].length; j++) {
//                f[i][j] = 0;
//            }
//        }

        return count(1, n, f);
    }

    public int count(int i, int j, int[][] f) {
        if (i >= j) {
            return 0;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, k + Math.max(count(i, k - 1, f), count(k + 1, j, f)));
        }
        f[i][j] = min;
        return min;
    }

    public int getMoneyAmount2(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(f[i][k - 1], f[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }
                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GuessNumSize guessNumSize = new GuessNumSize();
        System.out.println(guessNumSize.getMoneyAmount2(200));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + "ms");
    }


}
