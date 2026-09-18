package org.easy;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majorityElement = 0;
        int max = 0;
        int result = -1;
        if(nums.length > 0) result = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1])  majorityElement++;
            if(majorityElement > max)  {
                max = majorityElement;
                result = nums[i];
            }
        }
        return result;
    }
}
