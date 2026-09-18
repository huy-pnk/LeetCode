package org.data;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... vals) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    public int[] toArray() {
        int size = 0;
        ListNode cur = this;
        while (cur != null) { size++; cur = cur.next; }
        int[] arr = new int[size];
        cur = this;
        for (int i = 0; i < size; i++) { arr[i] = cur.val; cur = cur.next; }
        return arr;
    }
}
