/*
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
   . push(x) -- Push element x onto stack.
   . pop() -- Removes the element on top of the stack.
   . top() -- Get the top element.
   . getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<MinNum> minNums;

    public MinStack() {
        this.stack = new Stack<>();
        this.minNums = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minNums.isEmpty() || x < minNums.peek().num) {
            minNums.push(new MinNum(x));
        } else {
            minNums.peek().freq++;
        }
    }

    public void pop() {
        stack.pop();
        minNums.peek().freq--;
        if (minNums.peek().freq == 0) {
            minNums.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNums.peek().num;
    }
}

class MinNum {
    int num;
    int freq;

    MinNum(int num) {
        this.num = num;
        this.freq = 1;
    }
}
