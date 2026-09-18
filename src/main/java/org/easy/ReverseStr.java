package org.easy;

/**
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/?envType=problem-list-v2&envId=two-pointers
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i*2*k < charArray.length; i++) {
            int start = (i*2*k);
            int end;
            if(k >= charArray.length) end = charArray.length - 1;
            else end = (start + k - 1) >= charArray.length ? charArray.length-1: (start + k - 1);
            while (start < end && end <charArray.length) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }
}
