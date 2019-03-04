/*
https://leetcode.com/problems/implement-stack-using-queues/

Implement the following operations of a stack using queues.
   push(x) -- Push element x onto stack.
   pop() -- Removes the element on top of the stack.
   top() -- Get the top element.
   empty() -- Return whether the stack is empty.

Example:
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
*/

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q;
    private int top;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top = x;
    }

    public int pop() {
        for (int i = 1; i <= q.size() - 1; i++) {
            top = q.poll();
            q.offer(top);
        }

        return q.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
