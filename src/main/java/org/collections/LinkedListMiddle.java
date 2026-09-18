package org.collections;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Removing the middle element of a java.util.List (LinkedList in particular).
 *
 * <p>Note there is no fast/slow pointer walk here: unlike a raw ListNode chain,
 * LinkedList caches its size, so size() is O(1) and the middle index is arithmetic.
 * The O(n) cost is only the walk to that index, which LinkedList does from whichever
 * end is closer.
 */
public final class LinkedListMiddle {

    private LinkedListMiddle() {
    }

    /** floor(n / 2) — the UPPER middle when n is even. Same rule as LeetCode 2095. */
    public static int middleIndex(int size) {
        return size / 2;
    }

    /** floor((n - 1) / 2) — the LOWER middle. Differs from middleIndex only for even n. */
    public static int lowerMiddleIndex(int size) {
        return (size - 1) / 2;
    }

    /** Removes and returns the upper-middle element. */
    public static <T> T removeMiddle(List<T> list) {
        requireNonEmpty(list);
        return list.remove(middleIndex(list.size()));
    }

    /** Removes and returns the lower-middle element. */
    public static <T> T removeLowerMiddle(List<T> list) {
        requireNonEmpty(list);
        return list.remove(lowerMiddleIndex(list.size()));
    }

    /** Same result through a ListIterator: positioning is still O(n), the unlink is O(1). */
    public static <T> T removeMiddleWithIterator(List<T> list) {
        requireNonEmpty(list);
        ListIterator<T> it = list.listIterator(middleIndex(list.size()));
        T removed = it.next();
        it.remove();
        return removed;
    }

    private static void requireNonEmpty(List<?> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("cannot remove the middle of an empty list");
        }
    }
}
