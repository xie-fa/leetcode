package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2021/12/22
 * 28 StrStr
 **/
public class StrStr {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {

        int[] next = new int[needle.length()];

        //计算next数组
        for (int l = 0, r = 1; r < needle.length(); r++) {
            while (l > 0 && needle.charAt(l) != needle.charAt(r)) {
                l = next[l - 1];
            }
            if (needle.charAt(l) == needle.charAt(r)) {
                l++;
            }
            next[r] = l;
        }
        return next;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("hello","ll"));
    }


}
