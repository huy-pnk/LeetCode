package org.hard;


import java.util.HashSet;
import java.util.Set;

/**
 * 940. Distinct Subsequences II
 * https://leetcode.com/problems/distinct-subsequences-ii/
 */
public class DistinctSubseqII {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] end = new long[26];   // end[c] = distinct subsequences currently ending in c
        long total = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            long newEnd = (total + 1) % MOD;      // total so far + "c alone"
            total = (total - end[idx] + newEnd + MOD) % MOD; // +MOD guards against negative
            end[idx] = newEnd;
        }

        return (int) total;
    }
}
