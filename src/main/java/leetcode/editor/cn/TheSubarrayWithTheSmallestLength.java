package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/15
 **/
public class TheSubarrayWithTheSmallestLength {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        int start = 0, end = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
