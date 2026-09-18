package org.hard;

import java.util.*;

/**
 * 115. Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class NumDistinct {
//    public int numDistinct(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//
//        Map<Character, TreeSet<Integer>> map = new LinkedHashMap<>();
//
//        for (char c : tChars) {
//            for (int i = 0; i < sChars.length; i++) {
//                if(map.containsKey(c)) {
//                    if(sChars[i] == c)
//                        map.get(c).add(i);
//                }
//                else {
//                    if(sChars[i] == c) {
//                        TreeSet<Integer> treeSet = new TreeSet<>();
//                        treeSet.add(i);
//                        map.put(c, treeSet);
//                    }
//                }
//            }
//        }
//
//        return countCombinations(t, map);
//    }
//
//
//    public int countCombinations(String word, Map<Character, TreeSet<Integer>> map) {
//        List<Integer> prevIndices = new ArrayList<>();
//        List<Integer> prevWays = new ArrayList<>();
//
//        for (int k = 0; k < word.length(); k++) {
//            char c = word.charAt(k);
//            // Already sorted — no copy, no Collections.sort needed
//            NavigableSet<Integer> currIndices = map.getOrDefault(c, new TreeSet<>());
//
//            List<Integer> newIndices = new ArrayList<>();
//            List<Integer> newWays = new ArrayList<>();
//
//            if (k == 0) {
//                for (int idx : currIndices) {
//                    newIndices.add(idx);
//                    newWays.add(1);
//                }
//            } else {
//                int p = 0;
//                int runningSum = 0;
//                for (int idx : currIndices) { // sorted iteration, O(m)
//                    while (p < prevIndices.size() && prevIndices.get(p) < idx) {
//                        runningSum += prevWays.get(p);
//                        p++;
//                    }
//                    if (runningSum > 0) {
//                        newIndices.add(idx);
//                        newWays.add(runningSum);
//                    }
//                }
//            }
//
//            prevIndices = newIndices;
//            prevWays = newWays;
//
//            if (prevIndices.isEmpty()) return 0;
//        }
//
//        int total = 0;
//        for (int w : prevWays) total += w;
//        return total;
//    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // empty t: exactly one way
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j]; // don't use s[i-1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1]; // use s[i-1] to match
                }
            }
        }

        return dp[m][n];
    }


}
