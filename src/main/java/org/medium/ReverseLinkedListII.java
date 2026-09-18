package org.medium;

import org.data.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode tail = curr;

        ListNode reversePrev = null;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = reversePrev;
            reversePrev = curr;
            curr = next;
        }

        prev.next = reversePrev;
        tail.next = curr;

        return dummy.next;
    }
}
