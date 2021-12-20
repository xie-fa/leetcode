package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 475 供暖器
 *
 * @author xiefa
 **/
public class Heater {

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }


    public int findRadius(int[] houses, int[] heaters) {
        int minR = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int ld = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rd = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int d = Math.min(ld, rd);
            minR = Math.max(minR, d);
        }
        return minR;

    }


    //排序 + 二分
    //找出所有房屋最近的一个供暖器的位置 的最大值
    //如何求每个房屋距离最近的一个供暖器的位置 = 每个房屋距离最近的供暖器的位置，一定是房屋 左边最近一个 或者 右边最近一个 供暖器，因此找出距离其最近左右边的供暖器
    //那么问题转化：如何求每个房屋，左右边供暖器的位置
    //找到左边的供暖器
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > target) {
            //nums[0]比目标大
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Heater heater = new Heater();
        int[] houses = new int[]{1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999};
        int[] heaters = new int[]{499, 500, 501};
        System.out.println(heater.findRadius(houses, heaters));
    }
}
