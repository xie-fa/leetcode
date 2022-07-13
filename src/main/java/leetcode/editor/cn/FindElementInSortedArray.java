package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/14
 **/
public class FindElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int l = twoPoint(nums, target);
        if(l >= nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        //寻找大于target+1的索引
        int r = twoPoint(nums,target+1);
        return new int[]{l,r-1};
    }


    public int twoPoint(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 范围查询规律
     * 初始化:
     * int left = 0;
     * int right = nums.length - 1;
     * 循环条件
     * left <= right
     * 右边取值
     * right = mid - 1
     * 左边取值
     * left = mid + 1
     * 查询条件
     * >= target值, 则 nums[mid] >= target时, 都减right = mid - 1
     * >  target值, 则 nums[mid] >  target时, 都减right = mid - 1
     * <= target值, 则 nums[mid] <= target时, 都加left = mid + 1
     * <  target值, 则 nums[mid] <  target时, 都加left = mid + 1
     * 结果
     * 求大于(含等于), 返回left
     * 求小于(含等于), 返回right
     * 核心思想: 要找某个值, 则查找时遇到该值时, 当前指针(例如right指针)要错过它, 让另外一个指针(left指针)跨过他(体现在left <= right中的=号), 则找到了
     */
}
