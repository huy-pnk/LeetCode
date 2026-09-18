package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumClosetTest {
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();

    @Test
    void test1() {
        int[] input = new int[] {-1,2,1,-4};
        Assertions.assertEquals(2, threeSumClosest.threeSumClosest(input,1));
    }

    @Test
    void test2() {
        int[] input = new int[] {10,20,30,40,50,60,70,80,90};
        Assertions.assertEquals(60, threeSumClosest.threeSumClosest(input,1));
    }

    @Test
    void test3() {
        int[] input = new int[] {1,1,1,0};
        Assertions.assertEquals(3, threeSumClosest.threeSumClosest(input,100));
    }

    @Test
    void test4() {
        int[] input = new int[] {4,0,5,-5,3,3,0,-4,-5};
        Assertions.assertEquals(-2, threeSumClosest.threeSumClosest(input,-2));
    }

    @Test
    void test5() {
        int[] input = new int[] {0,3,97,102,200};
        Assertions.assertEquals(300, threeSumClosest.threeSumClosest(input,300));
    }

    @Test
    void test6() {
        int[] input = new int[] {0,1,2};
        Assertions.assertEquals(3, threeSumClosest.threeSumClosest(input,0));
    }

}
