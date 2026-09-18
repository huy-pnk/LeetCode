package org.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        nums = Arrays.stream(nums).distinct().toArray();

        int step = nums.length;
        while(step > 0) {
            for(int i=0;(i+step)<=nums.length;i++) {
                int count=1;
                List<Integer> temp = new ArrayList<>();
                while(count<=step) {

                    temp.add(nums[i]);
                    int j=i+1;
                    while(j<nums.length && temp.size() < step) {
                        temp.add(nums[j]);
                        j++;
                    }
                    count++;
                }
                result.add(temp);
            }
            step--;
        }

        return result;
    }
}
