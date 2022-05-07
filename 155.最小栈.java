/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    Deque<Integer> deque;
    Deque<Integer> min_deque;

    public MinStack() {
        deque = new LinkedList<Integer>();
        min_deque = new LinkedList<Integer>();
        min_deque.addLast(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque.addLast(val);
        min_deque.addLast(Math.min(min_deque.getLast(), val));
    }

    public void pop() {
        deque.removeLast();
        min_deque.removeLast();
    }

    public int top() {
        return deque.getLast();
    }

    public int getMin() {
        return min_deque.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
