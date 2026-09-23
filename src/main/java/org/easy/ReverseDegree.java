package org.easy;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 3498. Reverse Degree of a String
 * <a href="https://leetcode.com/problems/reverse-degree-of-a-string/">...</a>
 */
public class ReverseDegree {
    public int reverseDegree(String s) {
        Map<Character, Integer> map = IntStream.range(0, 26)
                .boxed()
                .collect(Collectors.toMap(i -> (char) ('a' + i), i -> i));
        int result = 0;
        char[] input = s.toCharArray();

        for(int i=0; i<input.length;i++) {
            int index = map.get(input[i]);
            int product = (26 - index)* (i+1);
            result += product;
        }

        return result;
    }
}
