package org.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int min = 0;
        int result = 0;
        boolean firstStep = true;
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++) {
            int left=i-1, right=i+1;
            while(left>=0 && right<nums.length) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum == target) return currentSum;
                if(firstStep) {
                    min = Math.abs(currentSum - target);
                    firstStep = false;
                }
                if(currentSum > target) left--;
                if(currentSum < target) right++;
                if(min >= Math.abs(currentSum - target)) {
                    min = Math.abs(currentSum - target);
                    result = currentSum;
                }
            }
        }
        return result;
    }
}
