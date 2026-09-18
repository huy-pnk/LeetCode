package org.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        candidates = Arrays.stream(candidates).sorted().toArray();
        int i=0;
        while(candidates[i] < target && i < candidates.length) {

        }
        return result;
    }
}
