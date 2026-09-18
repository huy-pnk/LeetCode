package org.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 697. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class FindShortestSubArray {
    record Interval(int start, int end, int count) {

    }
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int numberHasShortedArray = nums[0];
        Map<Integer, Interval> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                Interval interval = new Interval(i, i, 1);
                map.put(nums[i], interval);
            } else {
                Interval temp = map.get(nums[i]);
                Interval interval = new Interval(temp.start, i, temp.count + 1);
                if(degree < interval.count) {
                    degree = interval.count;
                    numberHasShortedArray = nums[i];
                } else if(degree == interval.count) {
                    int current = (i - interval.start) + 1;
                    int currentMin = (map.get(numberHasShortedArray).end - map.get(numberHasShortedArray).start) + 1;
                    if(currentMin > current) {
                        degree = interval.count;
                        numberHasShortedArray = nums[i];
                    }
                }
                map.put(nums[i], interval);
            }
        }
        Interval interval = map.get(numberHasShortedArray);
        return (interval.end - interval.start) + 1;
    }
}
