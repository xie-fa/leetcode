package leetcode.editor.cn;

import java.util.*;

/**
 * 373. 查找和最小的 K 对数字
 *
 * @author 11757
 * @date 2022/1/14
 **/
public class FindTheSumOfTheSmallestKPairsOfNumbers {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            }
        });

        List<List<Integer>> ansList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new int[]{i,0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] idxPair = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ansList.add(list);
            if (idxPair[1] + 1 < n) {
                queue.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ansList;
    }
}
