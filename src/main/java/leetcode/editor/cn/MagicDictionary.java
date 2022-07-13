package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/7/11
 **/
public class MagicDictionary {

    int N = 100 * 100, M = 26, idx = 0;
    int[][] trie = new int[N][M];
    boolean[] isEnd = new boolean[N * M];

    private void add(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                trie[p][u] = ++idx;
            }
            p = trie[p][u];
        }
        isEnd[p] = true;
    }

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            add(s);
        }
    }

    public boolean search(String s) {
        return query(s,0,0,1);
    }

    private boolean query(String s, int idx, int p, int limit) {
        if (limit < 0) {
            return false;
        }
        if (idx == s.length()) {
            return isEnd[p] && limit == 0;
        }
        int u = s.charAt(idx) - 'a';
        for (int i = 0; i < M;i++){
            if(trie[p][i] == 0){
                continue;
            }
            if(query(s,idx+1,trie[p][i],i==u?limit:limit-1)){
                return true;
            }
        }
        return false;
    }
}
