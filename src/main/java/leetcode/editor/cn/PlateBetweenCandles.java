package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/8
 **/
public class PlateBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] sum = new int[n + 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '|') {
                list.add(i);
            }
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        if (list.size() == 0) {
            return ans;
        }

        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = -1, d = -1;
            //找到a右边最近的蜡烛
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = (1 + r) / 2;
                if (list.get(mid) >= a) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            if (list.get(r) >= a) {
                c = list.get(r);
            } else {
                continue;
            }

            //找到b左边最近的蜡烛
            while (1 < r) {
                int mid = (1 + r + 1) / 2;
                if (list.get(mid) <= b) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(r) <= b) {
                d = list.get(r);
            } else {
                continue;
            }

            if (c <= d) {
                ans[i] = sum[d + 1] - sum[c];
            }

        }
        return ans;
    }


    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

}
