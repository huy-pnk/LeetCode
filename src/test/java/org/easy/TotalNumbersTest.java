package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotalNumbersTest {
    private final TotalNumbers totalNumbers = new TotalNumbers();

    @Test
    public void test1() {
        int[] digits = new int[] {1,2,3,4};
        Assertions.assertEquals(12, totalNumbers.totalNumbers(digits));
    }

    @Test
    public void test2() {
        int[] digits = new int[] {0,2,2};
        Assertions.assertEquals(2, totalNumbers.totalNumbers(digits));
    }

    @Test
    public void test3() {
        int[] digits = new int[] {6,6,6};
        Assertions.assertEquals(1, totalNumbers.totalNumbers(digits));
    }

    @Test
    public void test4() {
        int[] digits = new int[] {1,3,5};
        Assertions.assertEquals(0, totalNumbers.totalNumbers(digits));
    }

    @Test
    public void test5() {
        int[] digits = new int[] {0,5,6,6,7};
        Assertions.assertEquals(16, totalNumbers.totalNumbers(digits));
    }


}
