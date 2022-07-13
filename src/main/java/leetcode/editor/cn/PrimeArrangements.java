package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/6/30
 **/
public class PrimeArrangements {

    static int mod = (int) 1e9 + 7;

    static List<Integer> list = new ArrayList<>();

    //
    static {
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                list.add(i);
            }
        }
    }

    public int numPrimeArrangements(int n) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (list.get(mid) <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int a = r + 1;
        int b = n - a;
        long ans = 1;
        for (int i = b; i > 1; i--) {
            ans = ans * i % mod;
        }
        for(int i = a;i>1;i--){
            ans = ans * i % mod;
        }
        return Math.toIntExact(ans);
    }

    public static void main(String[] args) {
        PrimeArrangements primeArrangements = new PrimeArrangements();
        System.out.println(primeArrangements.numPrimeArrangements(100));
    }
}
