import java.util.*;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    Map<String, String> phone = new HashMap<String,String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        String combination = "";
        dfs(combination,digits);
        return list;
    }

    public void dfs(String combination,String nextDigit)
    {
        if(nextDigit.equals(""))
        {
            if(!combination.equals(""))
                list.add(combination);
        }
        else
        {
            String value = nextDigit.substring(0,1);
            String s = phone.get(value);
            for(int i = 0;i < s.length(); i++)
            {
                dfs(combination+s.substring(i,i+1),
                 nextDigit.substring(1));
            }
        }
    }
}
// @lc code=end
