package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/15
 **/
public class SumOfTwoNumbersII {

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int index = twoPoint(numbers, target - numbers[i], i, numbers.length - 1);
            if (index < numbers.length &&target == numbers[i] + numbers[index] ) {
                return new int[]{i+1, index+1};
            }
        }
        return null;
    }

    private int twoPoint(int[] numbers, int target, int l, int r) {

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (numbers[mid] > target) {
                r = mid - 1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SumOfTwoNumbersII sumOfTwoNumbersII = new SumOfTwoNumbersII();
        System.out.println(sumOfTwoNumbersII.twoSum(new int[]{0,0,3,4},0));
    }
}
