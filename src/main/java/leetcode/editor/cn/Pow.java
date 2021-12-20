package leetcode.editor.cn;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        long N = n;
        if (n < 0) {
            return 1 / splitCalculation(x, -N);
        }
        return splitCalculation(x, N);

    }

    public double splitCalculation(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double temp = splitCalculation(x, n / 2);
            return temp * temp;
        } else {
            double temp = splitCalculation(x, n / 2);
            return temp * temp * x;
        }
    }

    /**
     * 暴力
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {

        if (x == 1 || n == 0) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Pow pow = new Pow();
//        System.out.println(String.valueOf(pow.myPow1(1, 2147483647)));
        System.out.println(String.valueOf(pow.myPow(2, -2147483648)));
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }
}
