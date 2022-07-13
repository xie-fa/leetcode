package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/1/13
 **/
public class TheMaximumNumberThatDoublesTheNumber {

    public int dominantIndex(int[] nums) {
        int max = -1;
        int second = -1;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= 2 * second) {
            return index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        TheMaximumNumberThatDoublesTheNumber theNumber = new TheMaximumNumberThatDoublesTheNumber();
        System.out.println(theNumber.dominantIndex(new int[]{3, 1}));

    }
}
