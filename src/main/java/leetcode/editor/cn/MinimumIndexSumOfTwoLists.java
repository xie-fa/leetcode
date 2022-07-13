package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 11757
 * @date 2022/3/14
 **/
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        List<String> ans = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = map.get(list2[i]) + i;
                if (minIndex > index) {
                    minIndex = index;
                    ans.clear();
                    ans.add(list2[i]);
                } else if (minIndex == index) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
