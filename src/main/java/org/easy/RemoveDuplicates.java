package org.easy;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 26. Remove Duplicates from Sorted Array
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">...</a>
 */

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        Iterator<Integer> itr = treeSet.iterator();
        int index = 0;

        while (itr.hasNext()) {
            int value = itr.next();
            nums[index] = value;
            index ++;
        }
        return index;
    }

}
