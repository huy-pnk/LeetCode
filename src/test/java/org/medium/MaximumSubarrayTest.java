package org.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    @Test
    void Test1() {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(maximumSubarray.maxSubArray(nums), 6);
    }

    @Test
    void Test2() {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(maximumSubarray.maxSubArray(nums), 6);
    }
}
