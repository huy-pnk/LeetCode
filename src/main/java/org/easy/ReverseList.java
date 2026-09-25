package org.easy;

import org.data.ListNode;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp.next != null)  {
            stack.push(temp.val);
            temp = temp.next;
        }
        stack.push(temp.val);
        temp = head;
        while(head.next != null) {
            head.val = stack.pop();
            head = head.next;
        }
        head.val = stack.pop();
        return temp;
    }

}
