package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormArrayByConcatenatingSubarraysOfAnotherArrayTest {
    private final FormArrayByConcatenatingSubarraysOfAnotherArray formArrayByConcatenatingSubarraysOfAnotherArray = new FormArrayByConcatenatingSubarraysOfAnotherArray();

    @Test
    public void test1() {
        int[][] groups = {{1,-1,-1} , {3,-2,0}};
        int[] nums = {1,-1,0,1,-1,-1,3,-2,0};

        Assertions.assertTrue(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }

    @Test
    public void test2() {
        int[][] groups = {{10,-2} , {1,2,3,4}};
        int[] nums = {1,2,3,4,10,-2};

        Assertions.assertFalse(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }

    @Test
    public void test3() {
        int[][] groups = {{9099312,-7882487,-1441304,6624042,-6043305}};
        int[] nums = {-1441304,9099312,-7882487,-1441304,6624042,-6043305,-1441304};

        Assertions.assertTrue(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }

    @Test
    public void test4() {
        int[][] groups = {{21,22,21,22,21,30}};
        int[] nums = {21,22,21,22,21,22,21,30};

        Assertions.assertTrue(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }

    @Test
    public void test5() {
        int[][] groups = {{1,2}};
        int[] nums = {1,3,2};

        Assertions.assertFalse(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }


    @Test
    public void test6() {
        int[][] groups = {{1,2,3} , {3,4}};
        int[] nums = {7,7,1,2,3,4,7,7};

        Assertions.assertFalse(formArrayByConcatenatingSubarraysOfAnotherArray.canChoose(groups, nums));
    }
}
