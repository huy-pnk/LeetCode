package org.medium;

/**
 * 3871. Count Commas in Range II
 * https://leetcode.com/problems/count-commas-in-range-ii/
 */
public class CountCommas {
    public long countCommas(long n) {
        long t = 1000;
        long m = 1000000;
        long b = 1_000_000_000;
        long tr = 1000_000_000_000L;
        long tr2 = 1000_000_000_000_000L;
        long count = 0;
        if(n<t) return 0;
        if(n > t) {
            count = n - t + 1;
        }
        if(n > m) {
           count += n - m +1;
        }
        if(n > b) {
            count += n - b +1;
        }
        if(n> tr){
            count += n - tr +1;
        }
        if(n > tr2) {
            count += n - tr2 +1;
        }
        return count;
    }
}
