package org.easy;

/**
 * 3069. Distribute Elements Into Two Arrays I
 * https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
 */
public class ResultArray {
    public int[] resultArray(int[] nums) {
        int[] result = new int[nums.length] ;
        int i=0, j=1, index=0;
        int lastIndex1 = 0, lastIndex2 = 0;
        while(i < nums.length) {
            if(i == nums.length-1) {lastIndex1 = index; break;}
            result[index] = nums[i];
            i=i+2;
            index++;
        }

        while (j < nums.length) {
            if(nums.length % 2 == 0) {
                if(j<nums.length) {
                    result[index] = nums[j];
                    j=j+2;
                    index++;
                    if(j == nums.length-1) {lastIndex2 = index;}
                }
            }
            else {
                if(j<nums.length) {
                    result[index] = nums[j];
                    j=j+2;
                    index++;
                    if(j == nums.length-2) {lastIndex2 = index;}
                } else break;

            }
        }

        if(result[lastIndex1] > result[lastIndex2])  {
            result[lastIndex1] = nums[nums.length-1];
        } else {
            result[lastIndex2] = nums[nums.length-1];
        }

        return result;
    }
}
