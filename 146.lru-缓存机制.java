import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {
    // 节点类
    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode next;
        public DLinkedNode prev;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;
    private int volume;

    private DLinkedNode dummyHead;
    private DLinkedNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.volume = 0;
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            removeNode(node);
            addNode(node);
            System.out.println(node.value);
            return node.value;
        } else {
            System.out.println(- 1);
            return - 1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode newNode = new DLinkedNode(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            addNode(newNode);
        } else {
            if (volume < capacity)
                addNode(newNode);
            else {
                removeNode(dummyTail.prev);
                addNode(newNode);
            }
        }
    }

    private void removeNode(DLinkedNode node) {
        volume--;
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
        map.remove(node.key);
    }

    private void addNode(DLinkedNode node) {
        DLinkedNode next = dummyHead.next;
        volume++;
        dummyHead.next = node;
        next.prev = node;
        node.prev = dummyHead;
        node.next = next;

        map.put(node.key, node);        
    }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
