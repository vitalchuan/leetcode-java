import java.util.*;
/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

import org.w3c.dom.Node;

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // 如果该节点之前克隆过，直接返回克隆的节点
        if (visited.containsKey(node))
            return visited.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cloneNode);

        for (Node n : node.neighbors)
            cloneNode.neighbors.add(cloneGraph(n));

        return cloneNode;
    }
}
// @lc code=end
