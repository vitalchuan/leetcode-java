import java.util.*;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // dfs("", 0, 0, n);
        dfsWithStack(n);
        return result;
    }

    /**
     * 回溯法(深度优先搜素):递归实现
     * 
     * @param str   当前的String
     * @param left  当前String已经使用的左括号个数
     * @param right 当前String已经使用的右括号个数
     * @param n     总共需要几对括号
     */
    public void dfs(String str, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left == n + 1 || right == n + 1)
            return;

        // 若使用的左括号数量小于使用了的右括号数，则说明str已经无效
        if (left < right)
            return;
        dfs(str + "(", left + 1, right, n);
        dfs(str + ")", left, right + 1, n);
    }

    // dfs的栈实现
    private class Node {
        public String str;
        public int left;
        public int right;

        public Node(String str) {
            this.str = str;
        }

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * dfs的栈实现
     */
    public void dfsWithStack(int n)
    {
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(new Node("",0,0));
        while(!deque.isEmpty()){
            Node node = deque.removeFirst();
            if(node.left == n && node.right == n)
                result.add(node.str);
            else if(node.left<node.right)
                continue;
            else{
                if(node.left != n)
                    deque.addFirst(new Node(node.str+"(",node.left+1,node.right));
                if(node.right != n)
                    deque.addFirst(new Node(node.str+")",node.left,node.right+1));
            }
        }
    }
}
// @lc code=end
