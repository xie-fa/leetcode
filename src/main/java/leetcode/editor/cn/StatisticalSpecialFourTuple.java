package leetcode.editor.cn;

/**
 * 1995 统计特殊四元组
 *
 * @author 11757
 * @date 2021/12/29
 **/
public class StatisticalSpecialFourTuple {

    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
