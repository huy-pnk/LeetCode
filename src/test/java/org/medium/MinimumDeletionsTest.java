package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumDeletionsTest {
    private MinimumDeletions minimumDeletions = new MinimumDeletions();

    @Test
    public void test1() {
        int[] nums = {2,10,7,5,4,1,8,6};
        Assertions.assertEquals(5, minimumDeletions.minimumDeletions(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0,-4,19,1,8,-2,-3,5};
        Assertions.assertEquals(3, minimumDeletions.minimumDeletions(nums));
    }

    @Test
    public void test3() {
        int[] nums = {101};
        Assertions.assertEquals(1, minimumDeletions.minimumDeletions(nums));
    }

    @Test
    public void test4() {
        int[] nums = {-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28};
        Assertions.assertEquals(11, minimumDeletions.minimumDeletions(nums));
    }


}
