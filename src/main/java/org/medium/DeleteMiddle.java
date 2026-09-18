package org.medium;

import org.data.DoublyListNode;
import org.data.ListNode;

/**
 * LeetCode 2095 - Delete the Middle Node of a Linked List.
 * The middle is the node at index floor(n / 2), 0-indexed.
 */
public class DeleteMiddle {

    /**
     * Fast/slow pointers: fast moves twice per step, so when it falls off the end
     * slow sits on the middle. prev trails slow by one so the unlink is O(1).
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    /**
     * Same walk on a doubly linked list. The extra work is the back-link: dropping
     * {@code slow.next.prev} leaves a list that still reads correctly forward.
     */
    public DoublyListNode deleteMiddle(DoublyListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        DoublyListNode slow = head;
        DoublyListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow advanced at least once, so slow.prev is never null here
        slow.prev.next = slow.next;
        if (slow.next != null) {
            slow.next.prev = slow.prev;
        }
        slow.prev = null;
        slow.next = null;
        return head;
    }
}
