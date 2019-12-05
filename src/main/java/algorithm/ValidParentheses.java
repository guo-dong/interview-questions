package algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: guodong
 * @Date: 2018/11/5
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s==null || "".equals(s)){
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(!stack.empty() && stack.peek().equals(map.get(aChar))){
                stack.pop();
            }else{
                stack.push(aChar);
            }
        }
        if(stack.empty())return true;
        return false;
    }


    public static void main(String[] args) {

        System.out.println(isValid("()"));
    }

}
