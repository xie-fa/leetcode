package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/14
 **/
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        return twoPoints(nums, target, 0, nums.length - 1);
    }

    int twoPoints(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (l == r) {
            return -1;
        }
        //mid > r 说明旋转点在 mid 和 r之间，l 至 mid 是有序的
        if (nums[mid] > nums[r]) {
            if (nums[mid] > target && nums[l] <= target) {
                return twoPoints(nums, target, l, mid);
            } else {
                return twoPoints(nums, target, mid + 1, r);
            }
        } else {
            //mid < r 说明旋转点不在 mid 和 r之间， mid - r 是有序的
            if (nums[mid] < target && nums[r] >= target) {
                return twoPoints(nums, target, mid + 1, r);
            } else {
                return twoPoints(nums, target, l, mid);
            }
        }
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray sortedArray = new SearchRotatedSortedArray();
        System.out.println(sortedArray.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1
        }, 2));
    }
}
