package org.medium;

import org.data.DoublyListNode;
import org.data.ListNode;
import org.junit.jupiter.api.Test;

import static org.data.DoublyLinkedListAssert.assertList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class DeleteMiddleTest {

    private final DeleteMiddle solution = new DeleteMiddle();

    @Test
    void shouldDeleteMiddleOfOddLengthList() {
        // [1,3,4,7,1,2,6], n=7 -> index 3 (val 7) removed
        ListNode head = ListNode.of(1, 3, 4, 7, 1, 2, 6);
        assertArrayEquals(new int[]{1, 3, 4, 1, 2, 6}, solution.deleteMiddle(head).toArray());
    }

    @Test
    void shouldDeleteUpperMiddleOfEvenLengthList() {
        // [1,2,3,4], n=4 -> index 2 (val 3), not index 1
        ListNode head = ListNode.of(1, 2, 3, 4);
        assertArrayEquals(new int[]{1, 2, 4}, solution.deleteMiddle(head).toArray());
    }

    @Test
    void shouldDeleteMiddleOfThreeNodeList() {
        ListNode head = ListNode.of(1, 2, 3);
        assertArrayEquals(new int[]{1, 3}, solution.deleteMiddle(head).toArray());
    }

    @Test
    void shouldDeleteSecondNodeOfTwoNodeList() {
        // [2,1], n=2 -> index 1 (val 1) removed
        ListNode head = ListNode.of(2, 1);
        assertArrayEquals(new int[]{2}, solution.deleteMiddle(head).toArray());
    }

    @Test
    void shouldReturnNullForSingleNode() {
        assertNull(solution.deleteMiddle(ListNode.of(1)));
    }

    @Test
    void shouldReturnTheSameHeadObject() {
        ListNode head = ListNode.of(1, 2, 3);
        assertSame(head, solution.deleteMiddle(head), "head must not be reallocated");
    }

    @Test
    void shouldTerminateTheTailAfterUnlink() {
        // deleting the last-but-one node must leave a null-terminated list
        ListNode head = ListNode.of(1, 2);
        ListNode result = solution.deleteMiddle(head);
        assertNull(result.next);
    }

    // --- doubly linked variant: assertList also checks the prev pointers ---

    @Test
    void shouldDeleteMiddleAndRepairBothLinks() {
        DoublyListNode head = DoublyListNode.of(1, 2, 3, 4, 5);
        assertList(solution.deleteMiddle(head), 1, 2, 4, 5);
    }

    @Test
    void shouldDeleteUpperMiddleOfEvenDoublyList() {
        DoublyListNode head = DoublyListNode.of(1, 2, 3, 4);
        assertList(solution.deleteMiddle(head), 1, 2, 4);
    }

    @Test
    void shouldDeleteTailOfTwoNodeDoublyList() {
        DoublyListNode head = DoublyListNode.of(2, 1);
        assertList(solution.deleteMiddle(head), 2);
    }

    @Test
    void shouldReturnEmptyDoublyListForSingleNode() {
        assertList(solution.deleteMiddle(DoublyListNode.of(1)));
    }

    @Test
    void shouldDetachTheRemovedDoublyNode() {
        // the unlinked node must not keep pointing into the live list
        DoublyListNode head = DoublyListNode.of(1, 2, 3, 4 ,5);
        DoublyListNode middle = head.next;
        solution.deleteMiddle(head);
        assertNull(middle.prev);
        assertNull(middle.next);
    }
}
