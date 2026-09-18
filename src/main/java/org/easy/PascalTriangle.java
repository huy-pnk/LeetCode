package org.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            int num = (int)Math.pow(11, i);
            result.add(convertNumToList(num));
        }
        return result;
    }
    public List<Integer> convertNumToList(int num) {
        List<Integer> result = new LinkedList<>();
        while(num > 0) {
            int temp = num % 10;
            result.add(temp);
            num = num / 10;
        }
        Collections.reverse(result);
        return result.stream().collect(Collectors.toList());
    }
}
