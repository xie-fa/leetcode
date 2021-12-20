package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class RansomLetter {


    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] cnt = new int[26];

        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Integer> ransomMap = new HashMap<Character, Integer>();
//
//        if (ransomNote.length() > magazine.length()) {
//            return false;
//        }
//
//        for (int i = 0; i < magazine.length(); i++) {
//            char ch = magazine.charAt(i);
//            if (ransomMap.containsKey(ch)) {
//                ransomMap.put(ch, ransomMap.get(ch) + 1);
//            } else {
//                ransomMap.put(ch, 1);
//            }
//        }
//
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char ch = ransomNote.charAt(i);
//            if (ransomMap.containsKey(ch) && ransomMap.get(ch) >= 1) {
//                ransomMap.put(ch, ransomMap.get(ch) - 1);
//                continue;
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        RansomLetter ransomLetter = new RansomLetter();
        long start = System.currentTimeMillis();
        System.out.println(ransomLetter.canConstruct("ntwostmagerinmag", "giventwostingsransomnoteandmagazinereturntrueifransomnotecanbeconstructedfrommagazineandfalsotherwiseeachletterinmagazinecanonlybeusedonceinransomnote"));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (start - end) + "ms");
    }
}
