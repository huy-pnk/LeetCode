package org.data;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.data.DoublyLinkedListAssert.assertList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListAssertTest {

    @Test
    void shouldAcceptAWellFormedList() {
        assertList(DoublyListNode.of(1, 2, 3), 1, 2, 3);
    }

    @Test
    void shouldAcceptAnEmptyList() {
        assertList(DoublyListNode.of());
    }

    @Test
    void shouldAcceptASingleNode() {
        assertList(DoublyListNode.of(7), 7);
    }

    @Test
    void shouldWalkBothDirections() {
        DoublyListNode head = DoublyListNode.of(1, 2, 3);
        assertArrayEquals(new int[]{1, 2, 3}, head.toArray());
        assertArrayEquals(new int[]{3, 2, 1}, head.toArrayBackward());
    }

    @Test
    void shouldRejectWrongValues() {
        assertThrows(AssertionFailedError.class, () -> assertList(DoublyListNode.of(1, 2, 3), 1, 9, 3));
    }

    @Test
    void shouldRejectWrongLength() {
        assertThrows(AssertionFailedError.class, () -> assertList(DoublyListNode.of(1, 2), 1, 2, 3));
        assertThrows(AssertionFailedError.class, () -> assertList(DoublyListNode.of(1, 2, 3), 1, 2));
    }

    @Test
    void shouldRejectAStaleBackLink() {
        // forward values are still [1,2,3]; only the prev pointer is wrong
        DoublyListNode head = DoublyListNode.of(1, 2, 3);
        head.next.next.prev = head;
        assertThrows(AssertionFailedError.class, () -> assertList(head, 1, 2, 3));
    }

    @Test
    void shouldRejectANonNullHeadPrev() {
        DoublyListNode head = DoublyListNode.of(1, 2);
        head.prev = new DoublyListNode(0);
        assertThrows(AssertionFailedError.class, () -> assertList(head, 1, 2));
    }

    @Test
    void shouldFailFastOnACycleInsteadOfHanging() {
        DoublyListNode head = DoublyListNode.of(1, 2, 3);
        head.next.next.next = head.next; // 3 -> 2, cycle
        assertThrows(AssertionFailedError.class, () -> assertList(head, 1, 2, 3));
    }
}
