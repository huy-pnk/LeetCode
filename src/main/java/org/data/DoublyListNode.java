package org.data;

public class DoublyListNode {
    public int val;
    public DoublyListNode prev;
    public DoublyListNode next;

    public DoublyListNode() {
    }

    public DoublyListNode(int val) {
        this.val = val;
    }

    public DoublyListNode(int val, DoublyListNode prev, DoublyListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    /** Builds a well-formed list: head.prev and tail.next are null, every link is wired both ways. */
    public static DoublyListNode of(int... vals) {
        DoublyListNode dummy = new DoublyListNode();
        DoublyListNode cur = dummy;
        for (int v : vals) {
            cur.next = new DoublyListNode(v);
            cur.next.prev = cur;
            cur = cur.next;
        }
        DoublyListNode head = dummy.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }

    public DoublyListNode tail() {
        DoublyListNode cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public int[] toArray() {
        int size = 0;
        DoublyListNode cur = this;
        while (cur != null) { size++; cur = cur.next; }
        int[] arr = new int[size];
        cur = this;
        for (int i = 0; i < size; i++) { arr[i] = cur.val; cur = cur.next; }
        return arr;
    }

    /** Values from the tail back to the head, following prev. */
    public int[] toArrayBackward() {
        int size = 0;
        DoublyListNode cur = tail();
        while (cur != null) { size++; cur = cur.prev; }
        int[] arr = new int[size];
        cur = tail();
        for (int i = 0; i < size; i++) { arr[i] = cur.val; cur = cur.prev; }
        return arr;
    }
}
