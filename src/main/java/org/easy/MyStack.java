package org.easy;

import java.util.ArrayDeque;

/**
 * 225. Implement Stack using Queues
 * <a href="https://leetcode.com/problems/implement-stack-using-queues/">...</a>
 */
public class MyStack {
    private ArrayDeque<Integer> stack = new ArrayDeque<>();

    public MyStack() {
    }

    public void push(int x) {
        stack.offer(x);
        for (int i = stack.size() - 1; i > 0; i--) {
            stack.offer(stack.peek());
        }
    }

    public int pop() {
        if(!empty())
            return stack.removeFirst();
        else
            return 0;
    }

    public int top() {
        if(!empty())
            return stack.getFirst();
        else
            return 0;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

// 3 -> 2 -> 1
// 1 -> 2 -> 3
