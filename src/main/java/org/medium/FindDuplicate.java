package org.medium;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int n = nums.length - 1;
        for (int num : nums) {
            if (num < 1 || num > n) {
                throw new IllegalArgumentException(
                        "Value " + num + " is out of range [1, " + n + "]");
            }
        }

        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle using Floyd's tortoise and hare
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (the duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
