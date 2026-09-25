package org.easy;

import org.data.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseListTest {
    private final ReverseList reverseList = new ReverseList();

    @Test
    public void test1() {
        ListNode head = ListNode.of(1,2,3,4,5);
        assertArrayEquals(new int[]{5,4,3,2,1}, reverseList.reverseList(head).toArray());
    }
}
