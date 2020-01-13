import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        // HashMap<Integer,String> map = new HashMap<>();
        // map.put(1, "I");
        // map.put(4,"IV");
        // map.put(5, "V");
        // map.put(6, "VI");
        // map.put(10, "X");
        // map.put(40, "XL");
        // map.put(50, "L");
        // map.put(60, "LX");
        // map.put(100, "C");
        // map.put(400, "CD");
        // map.put(500, "D");
        // map.put(600, "DC");
        // map.put(1000, "M");

        int[] a = new int[]{1000,900,500,400,
            100,90,50,40,10,9,5,4,1};
        String[] b = new String[]{"M","CM","D","CD",
        "C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        String s = "";
        while(num > 0)
        {
            int count = num / a[index];
            while(count-- >0)
            {
                s = s + b[index];
            }
            num = num % a[index++];
        }
        return s;
    }
}
// @lc code=end

