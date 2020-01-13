import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("M",1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C",100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        int a = 0;
        while(!s.equals(""))
        {
            if(s.length() >= 2)
            {
                if(map.containsKey(s.substring(0,2)))
                {
                    a += map.get(s.substring(0, 2));
                    s = s.substring(2);
                }
                else
                {
                    a += map.get(s.substring(0,1));
                    s = s.substring(1);
                }
            }
            else
            {
                a += map.get(s.substring(0,1));
                s = s.substring(1);
            }
        }
        return a;
    }
}
// @lc code=end

