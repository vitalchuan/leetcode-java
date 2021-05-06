/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // BFS
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return root;
            
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> list = new LinkedList<>();
            int currentSize = queue.size();

            for (int i = 1; i <= currentSize; i++) {
                Node node = queue.poll();
                list.add(node);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }

        return root;
    }
}
// @lc code=end

