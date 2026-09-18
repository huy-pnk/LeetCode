package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInsertTest {
    private final SearchInsert searchInsert = new SearchInsert();

    @Test
    void test1() {
        Assertions.assertEquals(4, searchInsert.searchInsert(new int[]{ 2, 3, 4, 10, 40 }, 30));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, searchInsert.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    void test3() {
        Assertions.assertEquals(1, searchInsert.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    void test4() {
        Assertions.assertEquals(4, searchInsert.searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    void test5() {
        Assertions.assertEquals(0, searchInsert.searchInsert(new int[]{2,3,5,6}, 1));
    }

    @Test
    void test6() {
        Assertions.assertEquals(2, searchInsert.searchInsert(new int[]{1,4,6,7,8,9}, 6));
    }

    @Test
    void test7() {
        Assertions.assertEquals(2, searchInsert.searchInsert(new int[]{1,3,5}, 4));
    }
}
