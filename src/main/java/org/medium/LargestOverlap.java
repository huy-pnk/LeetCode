package org.medium;

import java.util.*;

/**
 * 835. Image Overlap
 * https://leetcode.com/problems/image-overlap/
 *
 */
public class LargestOverlap {
    public record Pair(int i, int j) {}
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Pair> listImg1 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[i].length; j++) {
                if(img1[i][j] == 1) {
                    Pair pair = new Pair(i, j);
                    listImg1.add(pair);
                }
            }
        }

        List<Pair> listImg2 = new ArrayList<>();
        for (int i = 0; i < img2.length; i++) {
            for (int j = 0; j < img2[i].length; j++) {
                if(img2[i][j] == 1) {
                    Pair pair = new Pair(i, j);
                    listImg2.add(pair);
                }
            }
        }

        Map<Pair, Integer> pairFreq = new HashMap<>();
        int max = 0;
        for (int i = 0; i < listImg1.size(); i++) {
            for (int j = 0; j < listImg2.size(); j++) {
                Pair pair = new Pair(listImg1.get(i).i - listImg2.get(j).i, listImg1.get(i).j - listImg2.get(j).j);
                int freq;
                if(pairFreq.containsKey(pair)) {
                    freq = pairFreq.get(pair)+1;
                } else {
                    freq = 1;
                }
                pairFreq.put(pair, freq);
                if(max < freq) max = freq;
            }
        }
        return max;
    }
}
