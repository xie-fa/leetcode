package leetcode.editor.cn;

import java.util.*;

/**
 * @author 11757
 * @date 2021/12/30
 * <p>
 * 846 一手顺子
 **/
public class StraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.get(cur) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int count = map.getOrDefault(cur + i, 0);
                if (count == 0) {
                    return false;
                }
                map.put(cur + i, count - 1);
            }
        }
        return true;
    }

    public boolean isNStraightHand1(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int cur : hand) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (int cur : hand) {
            if (!map.containsKey(cur)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int count = cur + j;
                if (!map.containsKey(count)) {
                    return false;
                }
                map.put(count, map.get(count) - 1);
                if (map.get(count) == 0) {
                    map.remove(count);
                }
            }
        }
        return true;
    }
}
