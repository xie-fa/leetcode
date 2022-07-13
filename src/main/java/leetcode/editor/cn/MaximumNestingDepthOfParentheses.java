package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * 1614.括号的最大嵌套深度
 *
 * @author 11757
 * @date 2022/1/7
 **/
public class MaximumNestingDepthOfParentheses {

    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
                if(stack.size() > max){
                    max = stack.size();
                }
            }else if(ch==')' && !stack.empty()){
                stack.pop();
            }
        }
        return max;
    }

    public int maxDepth1(String s){
        int ans = 0, size = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++size;
                ans = Math.max(ans, size);
            } else if (ch == ')') {
                --size;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfParentheses depth = new MaximumNestingDepthOfParentheses();
        System.out.println(depth.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
