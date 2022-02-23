package leetcode.editor.cn;

/**
 * 334. 递增的三元子序列
 *
 * @author 11757
 * @date 2022/1/12
 **/
public class IncreasingTernarySubsequence {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for(int i = 1; i < n-1; i++){
            if(nums[i] > leftMin[i] && nums[i] < rightMax[i]){
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums){
return false;
    }

    public static void main(String[] args) {
        IncreasingTernarySubsequence subsequence = new IncreasingTernarySubsequence();
        System.out.println(subsequence.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }


}
