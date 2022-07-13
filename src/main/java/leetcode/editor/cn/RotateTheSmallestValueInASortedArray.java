package leetcode.editor.cn;

/**
 * 旋转排序数组中的最小值
 * @author 11757
 * @date 2022/3/14
 **/
public class RotateTheSmallestValueInASortedArray {


    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

}
