package org.easy;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        int maxSubList = nums != null && nums.length > 0 ? nums[0] : 0;
        int index  = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1] + 1) maxSubList = maxSubList + nums[i];
            else  {
                index = i;
                break;
            }
        }
        for(int i=index;i<nums.length;i++) {
            if(maxSubList == nums[i]) maxSubList++;
        }
        return maxSubList;
    }


//    int maxSubList = nums != null && nums.length > 0 ? nums[0] : 0;
//    int currentSumSubList = 0;
//    int i = 0;
//    outer2:
//            while(i < nums.length) {
//        outer1:
//        if(i+1 < nums.length && nums[i+1] == nums[i] + 1) {
//            currentSumSubList = 0;
//            for(int j=i;j<nums.length;j++) {
//                currentSumSubList = currentSumSubList + nums[j];
//                if(maxSubList < currentSumSubList) maxSubList = currentSumSubList;
//                if(j+1 < nums.length && nums[j+1] != nums[j] + 1)  {
//                    i = j+1;
//                    break outer1;
//                } if(j == nums.length - 1) break outer2;
//            }
//        } else if(i < nums.length - 1) {
//            i++;//        } else break;
//    }
}
