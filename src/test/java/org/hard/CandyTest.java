package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CandyTest {
    private Candy candy = new Candy();
    @Test
    void test1() {
        Assertions.assertEquals(5, candy.candy(new int[] {1,0,2}));
    }

    @Test
    void test2() {
        Assertions.assertEquals(4, candy.candy(new int[] {1,2,2}));
    }

    @Test
    void test3() {
        Assertions.assertEquals(6, candy.candy(new int[] {1,2,3}));
    }

    @Test
    void test4() {
        Assertions.assertEquals(13, candy.candy(new int[] {1,2,87,87,87,2,1}));
    }
}
