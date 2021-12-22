package leetcode.editor.cn;

/**
 * @author xiefa
 * @date 2021-12-22
 * 686 重复叠加字符串匹配
 **/
public class RepeatedOverlayStringMatching {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }
        sb.append(a);
        int index = sb.indexOf(b);
        if (index == -1) {
            return -1;
        }
        if (index + b.length() > a.length() * ans) {
            return ans + 1;
        } else {
            return ans;
        }

    }

    public static void main(String[] args) {

    }
}
