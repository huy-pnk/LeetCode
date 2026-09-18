package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNumberOfFamiliesTest {
    private final MaxNumberOfFamilies maxNumberOfFamilies = new MaxNumberOfFamilies();

    @Test
    public void test1() {
        int n = 3;
        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};

        Assertions.assertEquals(4, maxNumberOfFamilies.maxNumberOfFamilies(n, reservedSeats));
    }

    @Test
    public void test2() {
        int n = 2;
        int[][] reservedSeats = {{2,1},{1,8},{2,6}};

        Assertions.assertEquals(2, maxNumberOfFamilies.maxNumberOfFamilies(n, reservedSeats));
    }



    @Test
    public void test3() {
        int n = 4;
        int[][] reservedSeats = {{4,3},{1,4},{4,6},{1,7}};

        Assertions.assertEquals(4, maxNumberOfFamilies.maxNumberOfFamilies(n, reservedSeats));
    }
}
