package org.medium;

import java.util.ArrayDeque;

public class PivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;
        int[] largerNums = new int[nums.length];
        int largerIndex = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                result[index] = nums[i];
                index++;
            } else if(nums[i] > pivot) {
                largerNums[largerIndex] = nums[i];
                largerIndex--;
            }
        }
        int equalPivot = nums.length - index- (nums.length-1 - largerIndex);
        largerIndex = nums.length-1;
        for (int i = index; i < nums.length; i++) {
            if(i < index+equalPivot) result[i] = pivot;
            else {
                result[i] = largerNums[largerIndex];
                largerIndex--;
            }
        }
        return result;
    }
}
