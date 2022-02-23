package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 11757
 * @date 2022/1/23
 **/
public class StockPrice {

    int maxtime;
    Map<Integer, Integer> map = new HashMap<>();
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        maxtime = Math.max(maxtime, timestamp);
        if (map.containsKey(timestamp)) {
            int old = map.get(timestamp);
            int cnt = treeMap.get(old);
            if (cnt == 1) {
                treeMap.remove(old);
            } else {
                treeMap.put(old, cnt - 1);
            }
        }
        map.put(timestamp, price);
        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(maxtime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
