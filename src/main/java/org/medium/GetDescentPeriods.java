package org.medium;

/**
 * 2110. Number of Smooth Descent Periods of a Stock
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/description/?envType=problem-list-v2&envId=two-pointers
 */
public class GetDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        long result = prices.length;

        // find the longest possible array
        long count = 1;
        int i = 0;
        while(i < prices.length) {
            if(i+1<prices.length && prices[i] == prices[i+1]+1) {
                for (int j = i+1; j+1<=prices.length; j++) {
                    count++;
                    if(j+1==prices.length || prices[j] != prices[j+1] + 1)  {
                        i = j;
                        break;
                    }
                }
                long temp = ((count * (count +1))/2) - count;
                result += temp;
                count = 1;
            }
            i++;
        }
        return result;
    }
}
