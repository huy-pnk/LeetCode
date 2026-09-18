package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSumRangeQueryTest {
    MaxSumRangeQuery maxSumRangeQuery = new MaxSumRangeQuery();

    @Test
    public void test1() {
        int[] nums = {1,2,3,4,5,6};
        int[][] request = {{0,1}};
        Assertions.assertEquals( 11, maxSumRangeQuery.maxSumRangeQuery(nums, request)) ;
    }

    @Test
    public void test2() {
        int[] nums = {1,2,3,4,5};
        int[][] request = {{1,3},{0,1}};
        Assertions.assertEquals( 19, maxSumRangeQuery.maxSumRangeQuery(nums, request)) ;
    }


    @Test
    public void test3() {
        int[] nums = {1,2,3,4,5,10};
        int[][] request = {{0,2},{1,3},{1,1}};
        Assertions.assertEquals( 47, maxSumRangeQuery.maxSumRangeQuery(nums, request)) ;
    }
}
