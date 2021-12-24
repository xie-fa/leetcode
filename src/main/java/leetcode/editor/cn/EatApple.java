package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * AUTHOR 11757
 * DATE 2021/12/24
 * 1705 吃最大数量的苹果
 **/
public class EatApple {


    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int i = 0;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            int rottenDay = i + days[i];
            int count = apples[i];
            if (count > 0) {
                pq.offer(new int[]{rottenDay, count});
            }
            if (!pq.isEmpty()) {
                int[] arr = pq.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    pq.poll();
                }
                ans++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] arr = pq.poll();
            int curr = Math.min(arr[0] - i, arr[1]);
            ans += curr;
            i += curr;
        }
        return ans;
    }

//    public int eatenApples(int[] apples, int[] days) {
//        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        int time = 0;
//        int n = apples.length;
//        int ans = 0;
//
//        while (time < n || !queue.isEmpty()) {
//            if (time < n && apples[time] > 0) {
//                //放入苹果
//                queue.add(new int[]{time + days[time] - 1, apples[time]});
//            }
//            while (!queue.isEmpty() && queue.peek()[0] < time) {
//                //去除腐烂的苹果
//                queue.poll();
//            }
//            if (!queue.isEmpty()) {
//                //优先吃快腐坏的苹果
//                int[] cur = queue.poll();
//                if (cur[0] > time && --cur[1] > 0) {
//                    //苹果还有剩
//                    queue.add(cur);
//                }
//                ans++;
//            }
//            time++;
//        }
//
//        return ans;
//    }
}
