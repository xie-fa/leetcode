package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 *
 * @author 11757
 * @date 2022/7/1
 **/
public class DifferentWaysToAddParentheses {

    char[] cs;

    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0, cs.length - 1);
    }

    private List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                continue;
            }
            List<Integer> lAns = dfs(l, i - 1);
            List<Integer> rAns = dfs(i + 1, r);
            for (int a : lAns) {
                for (int b : rAns) {
                    int cur = 0;
                    if (cs[i] == '+') {
                        cur = a + b;
                    } else if (cs[i] == '-') {
                        cur = a - b;
                    } else if (cs[i] == '*') {
                        cur = a * b;
                    }
                    ans.add(cur);
                }
            }
        }
        //纯数字
        if (ans.isEmpty()) {
            int cur = 0;
            for (int i = l; i <= r; i++) {
                cur = cur * 10 + (cs[i] - '0');
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses ways = new DifferentWaysToAddParentheses();
        List<Integer> integerList = ways.diffWaysToCompute("2*3-4*5");
        for(Integer ans:integerList){
            System.out.println(ans);
        }
    }
}
