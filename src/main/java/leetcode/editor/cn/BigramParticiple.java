package leetcode.editor.cn;

import java.util.*;

/**
 * @author 11757
 * @date 2021/12/26
 * 1078 Bigram分词
 **/
public class BigramParticiple {

    public String[] findOcurrences(String text, String first, String second) {
        String[] word = text.split(" ");
        List<String> ans = new ArrayList<>();
        for(int i = 2; i< word.length;i++){
            if(word[i-2].equals(first)&&word[i-1].equals(second)){
                ans.add(word[i]);
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {

    }

}
