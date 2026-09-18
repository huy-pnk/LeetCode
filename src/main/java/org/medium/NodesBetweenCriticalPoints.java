package org.medium;

import org.data.ListNode;


import java.util.Iterator;
import java.util.TreeSet;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */
public class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int maxDistance = -1, minDistance = -1;
        int lastIdx = -1;
        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;
        int i=1;
        ListNode previousNode = head;
        head = head.next;
        while(head != null && head.next != null) {
            if((previousNode.val > head.val && head.val < head.next.val) ||
                    (previousNode.val < head.val && head.val > head.next.val)) {
                if(lastIdx > -1) {
                    if(minDistance == -1) minDistance = i - lastIdx;
                    else minDistance = Math.min(i - lastIdx, minDistance);
                    lastIdx = i;
                }
                else
                    lastIdx = i;

                if(minIdx > i) minIdx = i;
                else if(maxIdx < i) maxIdx = i;
            }
            previousNode = head;
            head = head.next;
            i++;
        }
        if(minIdx != Integer.MAX_VALUE && maxIdx != Integer.MIN_VALUE) maxDistance = maxIdx - minIdx;
        return new int[]{minDistance, maxDistance};
    }
}
