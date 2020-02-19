import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
//双指针法 动态消除无效解
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 解法一：暴力搜索法，正确但会导致超时 时间复杂度：O(n^3)
         */
        // List<List<Integer>> list = new ArrayList<>();
        // // 遍历所有三元组
        // int i = 0, j = 1, k = 2;
        // // assert nums.length >= 3;

        // Arrays.sort(nums);// O(nlogn)
        // // 排序后 重复的List内部的值的顺序也会一致，方便contains去重。
        // for (i = 0; i <= nums.length - 3; i++) {
        //     for (j = i + 1; j <= nums.length - 2; j++)
        //         for (k = j + 1; k <= nums.length - 1; k++) {
        //             if ((nums[i] + nums[j] + nums[k]) == 0) {
        //                 List<Integer> ListInt = new LinkedList<>();
        //                 ListInt.add(nums[i]);
        //                 ListInt.add(nums[j]);
        //                 ListInt.add(nums[k]);
        //                 list.add(ListInt);
        //             }
        //         }
        // }
        // List<List<Integer>> list2 = new ArrayList<>();
        // // 去重
        // for (i = 0; i < list.size(); i++) {
        //     if (!list2.contains(list.get(i)))
        //         list2.add(list.get(i));
        // }

        // return list2;

        /**
         * 解法二：双指针法 时间复杂度：O(n^2)
         */
        List<List<Integer>> list = new LinkedList<>();

        Arrays.sort(nums);
        int i = 0, j = 1, k = nums.length - 1;
        for (i = 0; i <= nums.length - 3; i++, j = i + 1, k = nums.length - 1)
        {
            if (nums[i] > 0)
                break;// 不可能会有解
            // 开始进行双指针法排序
            if (i != 0)
                if (nums[i] == nums[i - 1])
                    continue;// 重复！
            while (j < k)
            {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp < 0) // j++直到不重复
                {
                    while (nums[j + 1] == nums[j])
                    {
                        j++;
                        if (j == nums.length - 1) break;
                    }
                    if (j != nums.length - 1) j++;
                } else if (tmp > 0)
                {
                    while (nums[k - 1] == nums[k])
                    {
                        k--;
                        if (k == i + 1) break;
                    }
                    if (k != i + 1) k--;
                } else if (tmp == 0)
                {
                    List<Integer> list2 = new LinkedList<>();
                    list2.add(nums[i]);
                    list2.add(nums[j]);
                    list2.add(nums[k]);
                    list.add(list2);

                    //防止数组访问越界
                    if (j != nums.length - 1)
                        j++;
                    while (j != nums.length - 1 && nums[j] == nums[j - 1])
                        j++;

                    if (k != i + 1)
                        k--;
                    while (k != i + 1 && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return list;
    }
}
// @lc code=end
