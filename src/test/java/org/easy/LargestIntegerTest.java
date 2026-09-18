package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestIntegerTest {
    private final LargestInteger largestInteger = new LargestInteger();

    @Test
    public void test1() {
        int[] nums = {3,9,9,7,2,1,7};
        int k = 1;

        Assertions.assertEquals(3, largestInteger.largestInteger(nums,k));
    }

    @Test
    public void test2() {
        int[] nums = {3,9,2,1,7};
        int k = 3;

        Assertions.assertEquals(7, largestInteger.largestInteger(nums,k));
    }

    @Test
    public void test3() {
        int[] nums = {7,5,9,10,0,12,3,12,10};
        int k =1;
        Assertions.assertEquals(9, largestInteger.largestInteger(nums,k));
    }

    @Test
    public void test4() {
        int[] nums = {10,12,9,7,10};
        int k =3;
        Assertions.assertEquals(-1, largestInteger.largestInteger(nums,k));
    }

    @Test
    public void test5() {
        int[] nums = {5,5,3};
        int k =1;
        Assertions.assertEquals(3, largestInteger.largestInteger(nums,k));
    }
}
