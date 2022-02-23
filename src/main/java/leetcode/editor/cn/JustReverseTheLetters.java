package leetcode.editor.cn;

/**
 * 917 仅仅反转字母
 *
 * @author 11757
 * @date 2022/2/23
 **/
public class JustReverseTheLetters {

    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = n - 1; i < j; ) {
            while (i<j && !Character.isLetter(cs[i])){
                i++;
            }
            while (i<j && !Character.isLetter(cs[j])){
                j--;
            }
            if(i<j){
                char c = cs[i];
                cs[i++] = cs[j];
                cs[j--] = c;
            }
        }
        return String.valueOf(cs);
    }
}
