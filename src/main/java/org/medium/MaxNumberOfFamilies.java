package org.medium;

import java.util.*;

public class MaxNumberOfFamilies {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;

        int blockA = 0b0000111100;
        int blockB = 0b0011110000;
        int blockC = 0b1111000000;

        Map<Integer, List<int[]>> groups = new TreeMap<>();

        for (int[] pair : reservedSeats) {
            int key = pair[0];
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(pair);
        }

        for (Map.Entry<Integer, List<int[]>> entry : groups.entrySet()) {
            int currentRow = 0b0000000000;
            for (int[] p : entry.getValue()) {
                currentRow |= (1 << p[1]);
            }

            if(currentRow == 0) result+=2;
            else {
                if(((currentRow & blockA) == 0) && ((currentRow & blockC) == 0)) result += 2;
                else {
                    if (((currentRow & blockA) == 0))  {result++; }
                    else if (((currentRow & blockB) == 0)) {result++; }
                    else if (((currentRow & blockC) == 0)) result++;
                }
            }
        }
        result += (n - groups.size()) * 2;
        return result;
    }
}
