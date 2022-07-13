package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 *
 * @author 11757
 * @date 2022/1/6
 **/
public class TheNearestSumOfThreeNumbers {


    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        int tmp = 0;
        int d = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int a = i + 1;
            int b = n - 1;
            while (a < b) {
                tmp = nums[i] + nums[a] + nums[b] - target;
                if (tmp == 0) {
                    return target;
                }
                if (Math.abs(tmp) < d) {
                    d = Math.abs(tmp);
                    sum = nums[i] + nums[a] + nums[b];
                }
                if (tmp > 0) {
                    b--;
                } else {
                    a++;
                }
            }
        }
        return sum;

    }

    /**
     * 暴力
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        int tmp = 0;
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    tmp = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if (tmp == 0) {
                        return target;
                    }
                    if (tmp < d) {
                        d = tmp;
                        sum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TheNearestSumOfThreeNumbers numbers = new TheNearestSumOfThreeNumbers();
        System.out.println(numbers.threeSumClosest1(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(numbers.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}