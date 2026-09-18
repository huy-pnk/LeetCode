package org.medium;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {
    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    public void test1() {
        int[] nums = {1,1,1,2,2,3};
        Assertions.assertEquals(5, removeDuplicates.removeDuplicates(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        Assertions.assertEquals(7, removeDuplicates.removeDuplicates(nums));
    }
}
