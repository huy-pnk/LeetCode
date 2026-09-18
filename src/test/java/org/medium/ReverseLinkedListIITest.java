package org.medium;

import org.data.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListIITest {

    private final ReverseLinkedListII solution = new ReverseLinkedListII();

    @Test
    void shouldReverseMiddleSegment() {
        // [1,2,3,4,5], left=2, right=4 -> [1,4,3,2,5]
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, solution.reverseBetween(head, 2, 4).toArray());
    }

    @Test
    void shouldReverseEntireList() {
        // [1,2,3,4,5], left=1, right=5 -> [5,4,3,2,1]
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, solution.reverseBetween(head, 1, 5).toArray());
    }

    @Test
    void shouldReturnSameWhenLeftEqualsRight() {
        // [1,2,3], left=2, right=2 -> [1,2,3] (no change)
        ListNode head = ListNode.of(1, 2, 3);
        assertArrayEquals(new int[]{1, 2, 3}, solution.reverseBetween(head, 2, 2).toArray());
    }

    @Test
    void shouldReverseFromHead() {
        // [3,5], left=1, right=2 -> [5,3]
        ListNode head = ListNode.of(3, 5);
        assertArrayEquals(new int[]{5, 3}, solution.reverseBetween(head, 1, 2).toArray());
    }

    @Test
    void shouldHandleSingleNodeList() {
        // [5], left=1, right=1 -> [5]
        ListNode head = ListNode.of(5);
        assertArrayEquals(new int[]{5}, solution.reverseBetween(head, 1, 1).toArray());
    }

    @Test
    void shouldReverseToTail() {
        // [1,2,3,4,5], left=3, right=5 -> [1,2,5,4,3]
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertArrayEquals(new int[]{1, 2, 5, 4, 3}, solution.reverseBetween(head, 3, 5).toArray());
    }
}
