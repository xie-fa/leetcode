package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884.两句话中的不常见单词
 *
 * @author 11757
 * @date 2022/1/30
 **/
public class UncommonWordsInTwoSentences {

    public String[] unco推多米诺mmonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        for (String s : s1s) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2s) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
