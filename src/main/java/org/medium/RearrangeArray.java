package org.medium;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 2149. Rearrange Array Elements by Sign
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */
public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        LinkedList<Integer> positiveList = new LinkedList<>();
        LinkedList<Integer> negativeList = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) positiveList.add(nums[i]);
            else negativeList.add(nums[i]);
        }
        while(!positiveList.isEmpty() && !negativeList.isEmpty()) {
            if(!positiveList.isEmpty()) {
                int positiveNum = positiveList.poll();
                result.add(positiveNum);
            }
            if(!negativeList.isEmpty()) {
                int negativeNum = negativeList.poll();
                result.add(negativeNum);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
