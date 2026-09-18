package org.easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int arr[], int l,
                     int r, int x)
    {
        if(arr[r-1] < x) return r;
        else if(arr[l] > x) return 0;
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present
            // at the middle itself
            if ((arr[mid] > x && arr[mid-1] < x) || arr[mid] == x)
                return mid;

            // If element is smaller than
            // mid, then it can only be
            // present in left subarray
            if (arr[mid] > x) {
                if(arr[mid-1] == x || (arr[mid] > x && arr[mid-1]<x)) return mid-1;
                else return binarySearch(arr, l,
                        mid - 1, x);
            }

            if(arr[mid+1] == x || (arr[mid] < x && arr[mid+1] > x)) return mid+1;
            else
                return binarySearch(arr, mid + 1,
                    r, x);
        }

        // Reach here when element is
        // not present in array
        return -1;
    }
}
