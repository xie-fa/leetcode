package leetcode.editor.cn;

/**
 * H 指数 II
 *
 * @author 11757
 * @date 2022/3/15
 **/
public class HIndexII {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
