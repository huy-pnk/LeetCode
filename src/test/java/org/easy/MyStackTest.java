package org.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Per the problem constraints, pop() and top() are only called on a non-empty
 * stack, so no test exercises them on an empty one.
 */
public class MyStackTest {

    /**
     * ["MyStack","push","push","top","pop","empty"]
     * [[],[1],[2],[],[],[]]
     * Expected: [null,null,null,2,2,false]
     */
    @Test
    public void officialExample() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        Assertions.assertEquals(2, stack.top());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertFalse(stack.empty());
    }

    @Test
    public void newStackIsEmpty() {
        Assertions.assertTrue(new MyStack().empty());
    }

    @Test
    public void singleElementRoundTrip() {
        MyStack stack = new MyStack();
        stack.push(42);
        Assertions.assertFalse(stack.empty());
        Assertions.assertEquals(42, stack.top());
        Assertions.assertEquals(42, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    /**
     * The smallest case that goes past two elements. A push that only moves the
     * old head to the back leaves the oldest element sitting at the front, so
     * the first pop already returns the wrong value here.
     */
    @Test
    public void popsThreeElementsInReverseOrder() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    /**
     * Several pops in a row with no push in between. An implementation that
     * reverses the remaining elements while removing one stays correct as long
     * as a push separates the pops, and only breaks on a run like this.
     */
    @Test
    public void popsRunConsecutivelyWithoutInterleavedPush() {
        MyStack stack = new MyStack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    @Test
    public void interleavesPushAndPop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        Assertions.assertEquals(2, stack.pop());
        stack.push(3);
        stack.push(4);
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    @Test
    public void topDoesNotRemoveTheElement() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.top());
        Assertions.assertEquals(3, stack.top());
        Assertions.assertEquals(3, stack.top());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.top());
        Assertions.assertFalse(stack.empty());
    }

    /** Calling top() must not disturb the order of the elements underneath it. */
    @Test
    public void popOrderSurvivesRepeatedTopCalls() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.top();
        stack.push(20);
        stack.top();
        stack.push(30);
        stack.top();
        Assertions.assertEquals(30, stack.pop());
        stack.top();
        Assertions.assertEquals(20, stack.pop());
        stack.top();
        Assertions.assertEquals(10, stack.pop());
    }

    @Test
    public void handlesDuplicateValues() {
        MyStack stack = new MyStack();
        stack.push(7);
        stack.push(7);
        stack.push(7);
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertEquals(7, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    @Test
    public void emptyTurnsTrueOnlyAfterTheLastPop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        Assertions.assertFalse(stack.empty());
        stack.pop();
        Assertions.assertFalse(stack.empty());
        stack.pop();
        Assertions.assertTrue(stack.empty());
    }

    /** A drained stack must behave like a brand new one. */
    @Test
    public void isReusableAfterBeingDrained() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        Assertions.assertTrue(stack.empty());

        stack.push(8);
        stack.push(9);
        Assertions.assertEquals(9, stack.pop());
        Assertions.assertEquals(8, stack.pop());
        Assertions.assertTrue(stack.empty());
    }

    /** LeetCode allows at most 100 calls, so this is the largest realistic size. */
    @Test
    public void popsFortyElementsInReverseOrder() {
        MyStack stack = new MyStack();
        for (int i = 1; i <= 40; i++) {
            stack.push(i);
        }
        for (int i = 40; i >= 1; i--) {
            Assertions.assertEquals(i, stack.pop(), "wrong element at depth " + i);
        }
        Assertions.assertTrue(stack.empty());
    }

    /**
     * Differential test: run random operation sequences against java.util.Deque
     * used as a stack and compare every single result. The fixed seed keeps a
     * failure reproducible, and the message carries the exact call sequence.
     */
    @Test
    public void matchesReferenceStackOnRandomSequences() {
        Random random = new Random(42);
        for (int trial = 0; trial < 500; trial++) {
            MyStack stack = new MyStack();
            Deque<Integer> reference = new ArrayDeque<>();
            StringBuilder calls = new StringBuilder();

            for (int op = 0; op < 40; op++) {
                if (reference.isEmpty() || random.nextInt(100) < 55) {
                    int value = random.nextInt(100);
                    calls.append("push(").append(value).append(") ");
                    stack.push(value);
                    reference.push(value);
                } else if (random.nextBoolean()) {
                    calls.append("pop() ");
                    Assertions.assertEquals(reference.pop(), stack.pop(), calls.toString());
                } else {
                    calls.append("top() ");
                    Assertions.assertEquals(reference.peek(), stack.top(), calls.toString());
                }
                Assertions.assertEquals(reference.isEmpty(), stack.empty(), calls.toString());
            }
        }
    }
}
