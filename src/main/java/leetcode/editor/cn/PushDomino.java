package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 838 推多米诺
 *
 * @author 11757
 * @date 2022/2/21
 **/
public class PushDomino {

    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') {
                continue;
            }
            int dire = cs[i] == 'L' ? -1 : 1;
            deque.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!deque.isEmpty()) {
            int[] info = deque.pollFirst();
            int loc = info[0];
            int time = info[1];
            int dire = info[2];

            int ne = loc + dire;
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) {
                //首次受力
                deque.add(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) {
                //多次受力
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }


}
