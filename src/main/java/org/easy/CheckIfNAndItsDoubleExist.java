package org.easy;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
 */
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        for(int i=arr.length-1;i>=0;i--) {
            // if arr[i] > 0
            if(arr[i] > 0) {
                for(int j=0;j<i;j++) {
                    if(arr[j] * 2 == arr[i] && i != j) return true;
                }
            } else {
                for(int j=i+1;j<arr.length;j++)
                    if(arr[j] * 2 == arr[i] && i != j) return true;
            }

        }
        return false;
    }
}
