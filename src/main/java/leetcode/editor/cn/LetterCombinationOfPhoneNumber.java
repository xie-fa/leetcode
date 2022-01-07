package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * @author 11757
 * @date 2022/1/6
 **/
public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(ans,map,digits,0,new StringBuffer());
        return ans;
    }

    private void dfs(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer combination) {
        if(index == digits.length()){
            list.add(combination.toString());
        }
        else {
            char num = digits.charAt(index);
            String letters = map.get(num);
            int len = letters.length();
            for(int i = 0; i < len;i++){
                combination.append(letters.charAt(i));
                dfs(list,map,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
