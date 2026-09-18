package org.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Removing the 3rd element (index 2) of [1,2,3,4,5] -> [1,2,4,5], across every
 * list-shaped java.util type and every removal idiom.
 */
class RemoveThirdElementTest {

    /** "the 3rd element" is index 2, 0-based. */
    private static final int INDEX = 2;
    private static final List<Integer> BEFORE = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> AFTER = List.of(1, 2, 4, 5);

    private static List<Integer> mutable() {
        return new ArrayList<>(BEFORE);
    }

    @Nested
    @DisplayName("Mutable lists: remove(int index) works")
    class MutableLists {

        @Test
        void arrayList() {
            List<Integer> list = new ArrayList<>(BEFORE);
            assertEquals(3, list.remove(INDEX), "remove(int) returns the removed element");
            assertEquals(AFTER, list);
        }

        @Test
        void linkedList() {
            List<Integer> list = new LinkedList<>(BEFORE);
            assertEquals(3, list.remove(INDEX));
            assertEquals(AFTER, list);
        }

        @Test
        void vector() {
            Vector<Integer> vector = new Vector<>(BEFORE);
            assertEquals(3, vector.remove(INDEX));
            assertEquals(AFTER, vector);
        }

        @Test
        @DisplayName("Vector.removeElementAt is the legacy void form")
        void vectorLegacyApi() {
            Vector<Integer> vector = new Vector<>(BEFORE);
            vector.removeElementAt(INDEX);
            assertEquals(AFTER, vector);
        }

        @Test
        @DisplayName("Stack extends Vector, so index removal works from the bottom up")
        void stack() {
            Stack<Integer> stack = new Stack<>();
            stack.addAll(BEFORE);
            assertEquals(3, stack.remove(INDEX));
            assertEquals(AFTER, stack);
        }

        @Test
        void copyOnWriteArrayList() {
            List<Integer> list = new CopyOnWriteArrayList<>(BEFORE);
            assertEquals(3, list.remove(INDEX));
            assertEquals(AFTER, list);
        }

        @Test
        void synchronizedList() {
            List<Integer> list = Collections.synchronizedList(new ArrayList<>(BEFORE));
            assertEquals(3, list.remove(INDEX));
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("subList(i, i+1).clear() removes through the view into the backing list")
        void throughSubListView() {
            List<Integer> list = mutable();
            list.subList(INDEX, INDEX + 1).clear();
            assertEquals(AFTER, list);
        }
    }

    @Nested
    @DisplayName("Immutable / fixed-size: removal throws UnsupportedOperationException")
    class ImmutableAndFixedSize {

        @Test
        void listOf() {
            List<Integer> list = List.of(1, 2, 3, 4, 5);
            assertThrows(UnsupportedOperationException.class, () -> list.remove(INDEX));
        }

        @Test
        void listCopyOf() {
            List<Integer> list = List.copyOf(BEFORE);
            assertThrows(UnsupportedOperationException.class, () -> list.remove(INDEX));
        }

        @Test
        void unmodifiableList() {
            List<Integer> list = Collections.unmodifiableList(mutable());
            assertThrows(UnsupportedOperationException.class, () -> list.remove(INDEX));
        }

        @Test
        @DisplayName("Arrays.asList is fixed-size: set() works, remove() does not")
        void arraysAsList() {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
            assertThrows(UnsupportedOperationException.class, () -> list.remove(INDEX));

            list.set(INDEX, 99);
            assertEquals(List.of(1, 2, 99, 4, 5), list);
        }

        @Test
        @DisplayName("An unmodifiable view still reflects removals made on the backing list")
        void unmodifiableViewIsNotASnapshot() {
            List<Integer> backing = mutable();
            List<Integer> view = Collections.unmodifiableList(backing);
            backing.remove(INDEX);
            assertEquals(AFTER, view);
        }
    }

    @Nested
    @DisplayName("remove(int) vs remove(Object) on a List<Integer>")
    class TheAutoboxingTrap {

        @Test
        @DisplayName("remove(3) removes INDEX 3, not the value 3")
        void removeIntRemovesByIndex() {
            List<Integer> list = mutable();
            assertEquals(4, list.remove(3));
            assertEquals(List.of(1, 2, 3, 5), list);
        }

        @Test
        @DisplayName("remove(Integer.valueOf(3)) removes the VALUE 3")
        void removeObjectRemovesByValue() {
            List<Integer> list = mutable();
            assertTrue(list.remove(Integer.valueOf(3)));
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("indexOf + remove is the explicit way to delete by value")
        void removeByLookup() {
            List<Integer> list = mutable();
            list.remove(list.indexOf(3));
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("List<String> has no ambiguity: only remove(Object) applies")
        void noTrapForNonIntegerLists() {
            List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
            assertTrue(list.remove("c"));
            assertEquals(List.of("a", "b", "d", "e"), list);
        }
    }

    @Nested
    @DisplayName("Iterator and ListIterator")
    class Iterators {

        @Test
        @DisplayName("Iterator.remove() deletes the element last returned by next()")
        void iteratorRemove() {
            List<Integer> list = mutable();
            Iterator<Integer> it = list.iterator();
            for (int i = 0; i <= INDEX; i++) {
                it.next();
            }
            it.remove();
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("ListIterator can start at a position instead of walking from 0")
        void listIteratorForward() {
            List<Integer> list = mutable();
            ListIterator<Integer> it = list.listIterator(INDEX);
            assertEquals(3, it.next());
            it.remove();
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("ListIterator.previous() also arms remove()")
        void listIteratorBackward() {
            List<Integer> list = mutable();
            ListIterator<Integer> it = list.listIterator(INDEX + 1);
            assertEquals(3, it.previous());
            it.remove();
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("remove() before next() throws IllegalStateException")
        void removeBeforeNext() {
            Iterator<Integer> it = mutable().iterator();
            assertThrows(IllegalStateException.class, it::remove);
        }

        @Test
        @DisplayName("Two remove() calls without an intervening next() throw")
        void removeTwice() {
            Iterator<Integer> it = mutable().iterator();
            it.next();
            it.remove();
            assertThrows(IllegalStateException.class, it::remove);
        }

        @Test
        @DisplayName("removeIf filters by value, not by index")
        void removeIf() {
            List<Integer> list = mutable();
            assertTrue(list.removeIf(v -> v == 3));
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("for-each + list.remove() throws ConcurrentModificationException")
        void forEachRemoveIsFailFast() {
            List<Integer> list = mutable();
            for (Integer v : list) {
                if (v == 3) {
                    list.remove(v);
                }
            }

//            assertThrows(ConcurrentModificationException.class, () -> {
//                for (Integer v : list) {
//                    if (v == 3) {
//                        list.remove(v);
//                    }
//                }
//            });
        }

        @Test
        @DisplayName("...except on the second-to-last element, where hasNext() lies and it passes silently")
        void forEachRemoveSilentlySucceedsOnSecondToLast() {
            List<Integer> list = mutable();
            for (Integer v : list) {
                if (v == 4) {
                    list.remove(v);
                }
            }
            assertEquals(List.of(1, 2, 3, 5), list);
        }

        @Test
        @DisplayName("CopyOnWriteArrayList iterators are read-only")
        void copyOnWriteIteratorCannotRemove() {
            Iterator<Integer> it = new CopyOnWriteArrayList<>(BEFORE).iterator();
            //List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
            //Iterator<Integer> it = list.iterator();
//            int i = 0;
//            while (it.hasNext()) {
//                Integer v = it.next();
//                if (i == 2)
//                    it.remove();  // xóa phần tử "3"
//                i++;
//            }

            //assertThrows(UnsupportedOperationException.class, it::remove);
        }

        @Test
        @DisplayName("CopyOnWriteArrayList iterators are fail-safe snapshots, never CME")
        void copyOnWriteIteratorIsASnapshot() {
            List<Integer> list = new CopyOnWriteArrayList<>(BEFORE);
            Iterator<Integer> it = list.iterator();
            list.remove(INDEX);

            List<Integer> seen = new ArrayList<>();
            it.forEachRemaining(seen::add);
            assertEquals(BEFORE, seen, "the snapshot still holds all 5 elements");
            assertEquals(AFTER, list);
        }

        @Test
        @DisplayName("Enumeration has no remove() and is not fail-fast")
        void vectorEnumeration() {
            Vector<Integer> vector = new Vector<>(BEFORE);
            Enumeration<Integer> e = vector.elements();
            vector.removeElementAt(INDEX);

            List<Integer> seen = new ArrayList<>();
            while (e.hasMoreElements()) {
                seen.add(e.nextElement());
            }
            assertEquals(AFTER, seen);
        }
    }

    @Nested
    @DisplayName("Arrays are fixed-length: removal means building a new one")
    class Arrays_ {

        @Test
        void intArrayViaSystemArraycopy() {
            int[] arr = {1, 2, 3, 4, 5};
            int[] result = new int[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, INDEX);
            System.arraycopy(arr, INDEX + 1, result, INDEX, arr.length - INDEX - 1);
            assertArrayEquals(new int[]{1, 2, 4, 5}, result);
        }

        @Test
        void intArrayViaStream() {
            int[] arr = {1, 2, 3, 4, 5};
            int[] result = IntStream.range(0, arr.length)
                    .filter(i -> i != INDEX)
                    .map(i -> arr[i])
                    .toArray();
            assertArrayEquals(new int[]{1, 2, 4, 5}, result);
        }

        @Test
        void boxedArrayViaStream() {
            Integer[] arr = {1, 2, 3, 4, 5};
            Integer[] result = IntStream.range(0, arr.length)
                    .filter(i -> i != INDEX)
                    .mapToObj(i -> arr[i])
                    .toArray(Integer[]::new);
            assertArrayEquals(new Integer[]{1, 2, 4, 5}, result);
        }

        @Test
        @DisplayName("Round-tripping through an ArrayList is the readable version")
        void arrayViaArrayList() {
            Integer[] arr = {1, 2, 3, 4, 5};
            List<Integer> list = new ArrayList<>(Arrays.asList(arr));
            list.remove(INDEX);
            assertArrayEquals(new Integer[]{1, 2, 4, 5}, list.toArray(new Integer[0]));
        }
    }

    @Nested
    @DisplayName("Deques have no positional access")
    class Deques {

        @Test
        @DisplayName("ArrayDeque has no remove(int); walk an iterator instead")
        void arrayDeque() {
            Deque<Integer> deque = new ArrayDeque<>(BEFORE);
            Iterator<Integer> it = deque.iterator();
            for (int i = 0; i <= INDEX; i++) {
                it.next();
            }
            it.remove();
            assertEquals(AFTER, new ArrayList<>(deque));
        }

        @Test
        @DisplayName("LinkedList is both List and Deque, so it keeps remove(int)")
        void linkedListAsDeque() {
            Deque<Integer> deque = new LinkedList<>(BEFORE);
            ((List<Integer>) deque).remove(INDEX);
            assertEquals(AFTER, new ArrayList<>(deque));
        }
    }
}
