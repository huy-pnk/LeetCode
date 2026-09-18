package org.algorithm;

public class BinarySearch {
    public int binarySearch(int[] arr, int target, int l, int r) {
        int mid = l + (r-l)/2;
        if(arr[mid] == target) return mid;

        if(arr[mid] > target) return binarySearch(arr, target, 0, mid-1);
        else return binarySearch(arr, target, mid+1, arr.length-1);
    }
}
