package org.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        LinkedList<Integer> mergedList = new LinkedList<>();
        int totalLength = nums1.length + nums2.length;
        double avg = 0.0;


        int medianIndex = 0;
        if(totalLength % 2 == 0) medianIndex = (totalLength/ 2) + 1;
        else medianIndex = (totalLength + 1) / 2;
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) mergedList.add(nums1[i++]);
            else mergedList.add(nums2[j++]);
            if(mergedList.size() == medianIndex) break;
        }

        while (i < nums1.length && mergedList.size() < medianIndex) {
            mergedList.add(nums1[i++]);
            if(mergedList.size() == medianIndex) break;
        }
        while (j < nums2.length && mergedList.size() < medianIndex) {
            mergedList.add(nums2[j++]);
            if(mergedList.size() == medianIndex) break;
        }

        if(totalLength %2==0 && mergedList.size() > 1)  {
            double num1 = mergedList.pollLast();
            double num2 = mergedList.pollLast();
            return (num1 + num2)/2;
        } else
            return mergedList.getLast();
    }
}
