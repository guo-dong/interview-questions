package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode.com/problems/generate-parentheses/
 * @Author: guodong
 * @Date: 2018/12/14
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result,"",0,0,n);
        return result;
    }

    public static void backTrack(List<String> result,String itemStr,int open,int close,int max){
        if(itemStr.length() == 2*max ){
            result.add(itemStr);
//            return;
        }else {
            if (open<max) backTrack(result,itemStr+"(",open+1,close,max);
            if (close<open) backTrack(result,itemStr+")",open,close+1,max);
        }

    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }


}
