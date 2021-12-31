package leetcode.editor.cn;

/**
 * 507 完美数
 *
 * @author 11757
 * @date 2021/12/31
 **/
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int ans = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i < num) {
                    ans += num / i;
                }
            }

        }
        return ans == num;
    }
}
