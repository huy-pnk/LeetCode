package org.easy;

import java.util.Arrays;

public class ThreeSum {
    public boolean findThreeSum(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }
}
