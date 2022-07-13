package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * @author 11757
 * @date 2022/1/7
 **/
public class ZGlyphTransformation {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        int cur = 0;
        int down = -1;
        for (int i = 0; i < s.length(); i++) {
            if (cur == 0 || cur == list.size() - 1) {
                down *= -1;
            }
            list.get(cur).append(s.charAt(i));
            cur += down;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder builder :list){
            ans.append(builder);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ZGlyphTransformation zGlyphTransformation = new ZGlyphTransformation();
        System.out.println(zGlyphTransformation.convert("PAYPALISHIRING",3));
    }
}
