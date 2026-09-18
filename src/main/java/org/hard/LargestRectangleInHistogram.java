package org.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int skipNumber = -1;
        for(int i=0;i<heights.length;i++) {
            while(skipNumber == heights[i]) {
                i++;
            }
            int m = i-1;
            int n = i+1;
            int count = 1;
            while(m>=0 && heights[m] >= heights[i]) {
                count++;
                m--;
            }
            while(n<heights.length && heights[n] >= heights[i]) {
                count++;
                n++;
            }
            if(n<heights.length && heights[n] == heights[i]) skipNumber = heights[i];
            int temp = heights[i] * count;
            if(max < temp) max = temp;
        }
        return max;
    }
}
