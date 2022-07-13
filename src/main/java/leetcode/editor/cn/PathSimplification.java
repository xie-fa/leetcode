package leetcode.editor.cn;

import java.util.*;

/**
 * 71. 简化路径
 * @author 11757
 * @date 2022/1/6
 **/
public class PathSimplification {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> list = Arrays.asList(path.split("/"));
        for (String s : list) {
            if(s.equals("..")){
                if(deque.isEmpty()){
                    continue;
                }
                deque.removeLast();
            }else if(!s.isEmpty()&&!s.equals(".")){
                deque.addLast(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()){
            ans.append("/").append(deque.removeFirst());
        }
        if(ans.length() == 0){
            ans.append("/");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        PathSimplification simplification = new PathSimplification();
        System.out.println(simplification.simplifyPath("/home//foo/"));
    }
}
