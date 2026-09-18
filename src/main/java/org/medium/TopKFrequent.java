package org.medium;

import java.util.*;

public class TopKFrequent {
    public record Interval(int num, int frequency) {}
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(Interval::frequency).reversed()
        );

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }

        for (var entry : map.entrySet()) {
            priorityQueue.add(new Interval(entry.getKey(), entry.getValue()));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll().num);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
