package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestOverlapTest {
    private final LargestOverlap largestOverlap = new LargestOverlap();

    @Test
    public void test1() {
        int[][] img1 = new int[][] {{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = {{0,0,0},{0,1,1},{0,0,1}};
        Assertions.assertEquals(3, largestOverlap.largestOverlap(img1, img2));
    }

    @Test
    public void test2() {
        int[][] img1 = new int[][] {{1,0},{1,0}};
        int[][] img2 = {{0,1},{1,0}};
        Assertions.assertEquals(1, largestOverlap.largestOverlap(img1, img2));
    }

    @Test
    public void test3() {
        int[][] img1 = new int[][] {{0}};
        int[][] img2 = {{0}};
        Assertions.assertEquals(0, largestOverlap.largestOverlap(img1, img2));
    }
}
