package org.medium;

import org.data.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
 */
public class NodesBetweenCriticalPointsTest {
    private final NodesBetweenCriticalPoints nodesBetweenCriticalPoints = new NodesBetweenCriticalPoints();

    @Test
    public void test1() {
        ListNode head = ListNode.of(new int[]{3,1});
        int[] result = new int[] {-1,-1};

        Assertions.assertArrayEquals(result, nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void test2() {
        int[] result = new int[] {1,3};
        ListNode head = ListNode.of(new int[]{5,3,1,2,5,1,2});

        Assertions.assertArrayEquals(result, nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void test3() {
        ListNode head = ListNode.of(new int[]{1,3,2,2,3,2,2,2,7});
        int[] result = new int[] {3,3};

        Assertions.assertArrayEquals(result, nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head));
    }

    @Test
    public void test4() {
        ListNode head = ListNode.of(new int[]{2,2,1,3});
        int[] result = new int[] {-1, -1};

        Assertions.assertArrayEquals(result, nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head));
    }
}
