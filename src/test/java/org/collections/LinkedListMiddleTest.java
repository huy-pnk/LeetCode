package org.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.collections.LinkedListMiddle.lowerMiddleIndex;
import static org.collections.LinkedListMiddle.middleIndex;
import static org.collections.LinkedListMiddle.removeLowerMiddle;
import static org.collections.LinkedListMiddle.removeMiddle;
import static org.collections.LinkedListMiddle.removeMiddleWithIterator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListMiddleTest {

    private static LinkedList<Integer> listOf(int... vals) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int v : vals) {
            list.add(v);
        }
        return list;
    }

    @Nested
    @DisplayName("Which index counts as the middle")
    class MiddleIndex {

        @ParameterizedTest(name = "n={0} -> upper middle index {1}")
        @CsvSource({"1,0", "2,1", "3,1", "4,2", "5,2", "6,3", "7,3", "8,4"})
        void upperMiddle(int size, int expected) {
            assertEquals(expected, middleIndex(size));
        }

        @ParameterizedTest(name = "n={0} -> lower middle index {1}")
        @CsvSource({"1,0", "2,0", "3,1", "4,1", "5,2", "6,2", "7,3", "8,3"})
        void lowerMiddle(int size, int expected) {
            assertEquals(expected, lowerMiddleIndex(size));
        }

        @ParameterizedTest(name = "n={0}: both conventions agree")
        @CsvSource({"1", "3", "5", "7", "9"})
        void conventionsAgreeForOddSizes(int size) {
            assertEquals(middleIndex(size), lowerMiddleIndex(size));
        }

        @ParameterizedTest(name = "n={0}: conventions differ by exactly 1")
        @CsvSource({"2", "4", "6", "8"})
        void conventionsDifferForEvenSizes(int size) {
            assertEquals(middleIndex(size) - 1, lowerMiddleIndex(size));
        }
    }

    @Nested
    @DisplayName("removeMiddle on a LinkedList")
    class RemoveMiddle {

        @Test
        @DisplayName("odd size: the true centre is removed")
        void oddSize() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            assertEquals(3, removeMiddle(list));
            assertEquals(List.of(1, 2, 4, 5), list);
        }

        @Test
        @DisplayName("even size: the UPPER of the two centres is removed")
        void evenSize() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4);
            assertEquals(3, removeMiddle(list));
            assertEquals(List.of(1, 2, 4), list);
        }

        @Test
        void threeElements() {
            LinkedList<Integer> list = listOf(1, 2, 3);
            assertEquals(2, removeMiddle(list));
            assertEquals(List.of(1, 3), list);
        }

        @Test
        @DisplayName("two elements: the second one goes")
        void twoElements() {
            LinkedList<Integer> list = listOf(1, 2);
            assertEquals(2, removeMiddle(list));
            assertEquals(List.of(1), list);
        }

        @Test
        void singleElement() {
            LinkedList<Integer> list = listOf(42);
            assertEquals(42, removeMiddle(list));
            assertTrue(list.isEmpty());
        }

        @Test
        @DisplayName("empty list throws NoSuchElementException, like removeFirst()")
        void emptyList() {
            LinkedList<Integer> list = new LinkedList<>();
            assertThrows(NoSuchElementException.class, () -> removeMiddle(list));
        }

        @Test
        @DisplayName("even size, lower convention: the LOWER centre is removed instead")
        void lowerMiddleOnEvenSize() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4);
            assertEquals(2, removeLowerMiddle(list));
            assertEquals(List.of(1, 3, 4), list);
        }

        @Test
        @DisplayName("odd size: both conventions remove the same element")
        void lowerMiddleOnOddSize() {
            assertEquals(3, removeLowerMiddle(listOf(1, 2, 3, 4, 5)));
            assertEquals(3, removeMiddle(listOf(1, 2, 3, 4, 5)));
        }
    }

    @Nested
    @DisplayName("Iterator-based removal gives the same answer")
    class ViaIterator {

        @Test
        void listIteratorMatchesIndexRemoval() {
            assertEquals(3, removeMiddleWithIterator(listOf(1, 2, 3, 4, 5)));
            assertEquals(3, removeMiddleWithIterator(listOf(1, 2, 3, 4)));
        }

        @Test
        void listIteratorLeavesTheSameList() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            removeMiddleWithIterator(list);
            assertEquals(List.of(1, 2, 4, 5), list);
        }

        @Test
        @DisplayName("hand-rolled Iterator walk reaches the same element")
        void plainIterator() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            Iterator<Integer> it = list.iterator();
            Integer removed = null;
            for (int i = 0; i <= middleIndex(list.size()); i++) {
                removed = it.next();
            }
            it.remove();
            assertEquals(3, removed);
            assertEquals(List.of(1, 2, 4, 5), list);
        }

        @Test
        @DisplayName("removing the middle inside a for-each throws ConcurrentModificationException")
        void forEachRemovalIsFailFast() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            int i = 0;
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()) {
                Integer v = it.next();
                if (i == 2)
                    it.remove();
                i++;
            }
        }

        @Test
        @DisplayName("Iterator.remove() xoá được phần tử thứ 4 và vòng lặp vẫn chạy tiếp")
        void iteratorCanRemoveFourthElement() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);

            for (Integer a : list) {
                list.remove(a);
            }

            int i = 0;
            for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
                it.next();
                if (i == 3) it.remove();
                i++;
            }
            assertEquals(List.of(1, 2, 3, 5), list);
        }
    }

    @Nested
    @DisplayName("State of the list after the removal")
    class AfterRemoval {

        @Test
        void sizeDropsByOne() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            removeMiddle(list);
            assertEquals(4, list.size());
        }

        @Test
        @DisplayName("the ends are untouched")
        void endsAreUnchanged() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            removeMiddle(list);
            assertEquals(1, list.getFirst());
            assertEquals(5, list.getLast());
        }

        @Test
        @DisplayName("Deque operations still work on both ends")
        void stillUsableAsDeque() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            removeMiddle(list);
            Deque<Integer> deque = list;
            assertEquals(1, deque.pollFirst());
            assertEquals(5, deque.pollLast());
            assertEquals(List.of(2, 4), list);
        }

        @Test
        @DisplayName("repeatedly removing the middle drains the list in this order")
        void drainByMiddle() {
            LinkedList<Integer> list = listOf(1, 2, 3, 4, 5);
            List<Integer> removed = new ArrayList<>();
            while (!list.isEmpty()) {
                removed.add(removeMiddle(list));
            }
            assertEquals(List.of(3, 4, 2, 5, 1), removed);
        }

        @Test
        @DisplayName("duplicates: removal is positional, the other copies survive")
        void duplicatesAreRemovedByPositionNotValue() {
            LinkedList<Integer> list = listOf(1, 2, 2, 2, 3);
            assertEquals(2, removeMiddle(list));
            assertEquals(List.of(1, 2, 2, 3), list);
        }

        @Test
        @DisplayName("LinkedList permits null, so the middle element may legitimately be null")
        void nullMiddleElement() {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            list.add(2);
            list.add(null);
            list.add(4);
            list.add(5);
            assertNull(removeMiddle(list));
            assertEquals(List.of(1, 2, 4, 5), list);
        }
    }

    @Nested
    @DisplayName("Traps specific to LinkedList<Integer>")
    class Traps {

        @Test
        @DisplayName("remove(middleIndex) is remove(int); remove(value) would be remove(Object)")
        void indexVersusValue() {
            LinkedList<Integer> byIndex = listOf(10, 20, 30, 40, 50);
            byIndex.remove(middleIndex(byIndex.size()));
            assertEquals(List.of(10, 20, 40, 50), byIndex);

            LinkedList<Integer> byValue = listOf(10, 20, 30, 40, 50);
            byValue.remove(Integer.valueOf(middleIndex(byValue.size())));
            assertEquals(List.of(10, 20, 30, 40, 50), byValue, "no element equals 2, nothing removed");
        }

        @Test
        @DisplayName("the helper works on any List, not just LinkedList")
        void worksOnArrayListToo() {
            List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
            LinkedList<Integer> linkedList = listOf(1, 2, 3, 4, 5);
            assertEquals(removeMiddle(linkedList), removeMiddle(arrayList));
            assertEquals(linkedList, arrayList);
        }

        @Test
        @DisplayName("an immutable list cannot be modified at all")
        void immutableListRejectsRemoval() {
            assertThrows(UnsupportedOperationException.class, () -> removeMiddle(List.of(1, 2, 3, 4, 5)));
        }
    }
}
