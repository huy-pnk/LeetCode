package org.easy;

/**
 * 3870. Count Commas in Range
 * https://leetcode.com/problems/count-commas-in-range/
 */
public class CountCommas {
    public int countCommas(int n) {
        int thousand = 1000;
        int tenThousand = 10000;

        if(n<thousand) return 0;
        if(n<tenThousand) {
            return n - thousand + 1;
        } else {
            return 9000 + (n-tenThousand);
        }
    }
}
