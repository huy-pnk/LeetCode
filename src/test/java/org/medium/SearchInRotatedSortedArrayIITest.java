package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInRotatedSortedArrayIITest {
    private final SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();

    @Test
    void test1() {
        Assertions.assertTrue(searchInRotatedSortedArrayII.search(new int[] {2,5,6,0,0,1,2}, 0));
    }

    @Test
    void test2() {
        Assertions.assertFalse(searchInRotatedSortedArrayII.search(new int[] {2,5,6,0,0,1,2}, 3));
    }

    @Test
    void test3() {
        Assertions.assertTrue(searchInRotatedSortedArrayII.search(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }
}
