package org.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaxOperations {
    record Pair(int num1, int num2){}
    public int maxOperations(int[] nums, int k) {
        Set<Pair> result = new HashSet<>();
        Arrays.sort(nums);
        int index = binarySearch(nums, k);
        for(int i=0;i<=index;i++) {
            for (int j = index; j >i ; j--) {
                if(nums[i] + nums[j] == k) result.add(new Pair(nums[i], nums[j]));
            }
        }
        return result.size();
    }

    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return arr.length - 1;
    }
}
