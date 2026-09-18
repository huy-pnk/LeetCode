package org.medium;

import java.util.*;

/**
 * 2904. Shortest and Lexicographically Smallest Beautiful String
 * https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 */
public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String s, int k) {
        int[] temp = new int[s.length()];
        int index = 0;


        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                temp[index] = i;
                index++;
            }
        }
        if(index == 0 && s.charAt(0) == '0' && k > 0) return "";
        if(k == 1) return String.valueOf(s.charAt(temp[index-1]));
        if(index < k) return "";

        // ---- find smallestLen
        int smallestLen = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < index; i++) {
            int len = temp[i + k - 1] - temp[i] + 1;
            if (len < smallestLen) {
                smallestLen = len;
            }
        }

        int bestStart = -1;
        for (int i = 0; i+k-1 <= index; i++) {
            if(i+k-1 >= temp.length) break;
            int start = temp[i];
            int len = temp[i + k - 1] - start + 1;
            if (len != smallestLen) continue;
            if (bestStart == -1) {
                bestStart = start;
                continue;
            }

            if (isSmaller(s, start, bestStart, smallestLen)) {
                bestStart = start;
            }
        }
        return s.substring(bestStart, bestStart + smallestLen);
    }

    private boolean isSmaller(String s, int a, int b, int len) {
        for (int offset = 0; offset < len; offset++) {
            char ca = s.charAt(a + offset);
            char cb = s.charAt(b + offset);
            if (ca != cb) {
                return ca < cb;
            }
        }
        return false;
    }
}
