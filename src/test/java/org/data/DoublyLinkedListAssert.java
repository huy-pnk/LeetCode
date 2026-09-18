package org.data;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * One assertion for doubly linked lists: values in order, plus the structural invariants that
 * a plain toArray() comparison silently misses.
 *
 * <p>Checks, in order:
 * <ul>
 *   <li>head.prev == null and tail.next == null</li>
 *   <li>forward values match {@code expected}</li>
 *   <li>node.next.prev == node for every link (same object, not just same value)</li>
 *   <li>walking prev from the tail yields {@code expected} reversed and stops at the head</li>
 *   <li>the forward walk is capped at expected.length, so a cycle fails instead of hanging</li>
 * </ul>
 *
 * <pre>{@code
 * DoublyListNode head = DoublyListNode.of(1, 2, 3);
 * assertList(solution.someOp(head), 1, 3, 2);
 * assertList(solution.removeAll(head));            // expects an empty list
 * }</pre>
 */
public final class DoublyLinkedListAssert {

    private DoublyLinkedListAssert() {
    }

    public static void assertList(DoublyListNode head, int... expected) {
        if (expected.length == 0) {
            assertNull(head, () -> "expected an empty list but got " + preview(head));
            return;
        }

        assertNotNull(head, () -> "expected " + Arrays.toString(expected) + " but the list was empty");
        assertNull(head.prev, () -> "head.prev must be null but pointed at " + head.prev.val);

        DoublyListNode tail = assertForward(head, expected);

        assertNull(tail.next, () -> "tail.next must be null but pointed at " + tail.next.val);
        assertBackward(tail, expected);
    }

    /** Forward walk: values, next/prev agreement, length. Returns the tail. */
    private static DoublyListNode assertForward(DoublyListNode head, int[] expected) {
        DoublyListNode cur = head;
        DoublyListNode tail = null;
        int i = 0;
        while (cur != null) {
            if (i == expected.length) {
                fail("list is longer than expected " + Arrays.toString(expected)
                        + " (or has a cycle); extra value at index " + i + " is " + cur.val);
            }
            final DoublyListNode node = cur;
            final int index = i;
            assertEquals(expected[i], cur.val, () -> "wrong value at index " + index);
            if (cur.next != null) {
                assertSame(node, node.next.prev,
                        () -> "broken back-link: node at index " + index + " (val " + node.val
                                + ") is not reachable via next.prev");
            }
            tail = cur;
            cur = cur.next;
            i++;
        }
        final int length = i;
        assertEquals(expected.length, length,
                () -> "list is shorter than expected " + Arrays.toString(expected) + ", had " + length + " nodes");
        return tail;
    }

    /** Backward walk from the tail: values in reverse, prev/next agreement, stops at the head. */
    private static void assertBackward(DoublyListNode tail, int[] expected) {
        DoublyListNode cur = tail;
        for (int i = expected.length - 1; i >= 0; i--) {
            final int index = i;
            assertNotNull(cur, () -> "backward walk ended at index " + index
                    + "; a prev pointer is null too early in " + Arrays.toString(expected));
            final DoublyListNode node = cur;
            assertEquals(expected[i], cur.val, () -> "wrong value at index " + index + " walking backward");
            if (cur.prev != null) {
                assertSame(node, node.prev.next,
                        () -> "broken forward-link: node at index " + index + " (val " + node.val
                                + ") is not reachable via prev.next");
            }
            cur = cur.prev;
        }
        final DoublyListNode beyondHead = cur;
        assertNull(beyondHead, () -> "backward walk ran past the head; extra node with val " + beyondHead.val);
    }

    /** Bounded peek used only in failure messages, so a cycle cannot hang the report. */
    private static String preview(DoublyListNode head) {
        StringBuilder sb = new StringBuilder("[");
        DoublyListNode cur = head;
        for (int i = 0; cur != null && i < 10; i++) {
            sb.append(i > 0 ? ", " : "").append(cur.val);
            cur = cur.next;
        }
        return sb.append(cur != null ? ", ...]" : "]").toString();
    }
}
