package leetcode.editor.cn;

/**
 * 寻找峰值
 *
 * @author 11757
 * @date 2022/3/14
 **/
public class FindPeaks {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l - r) / 2 + l;
            if(nums[mid] > nums[mid+1] ){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return r;
    }
}
