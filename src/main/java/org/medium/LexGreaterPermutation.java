package org.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3720. Lexicographically Smallest Permutation Greater Than Target
 * https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/
 */
public class LexGreaterPermutation {
    public String lexGreaterPermutation(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        char[] targetChars = target.toCharArray();
        if(chars.length == 0) return "";
        if(chars.length == 1 && chars[0] < targetChars[0]) return "";
        // chars array to map
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) map.put(chars[i], 1);
            else map.put(chars[i], map.get(chars[i]) + 1);
        }

        boolean flag = true;
        for (int i=0;i < targetChars.length;i++) {
            if(map.containsKey(targetChars[i])) {
                int frequency = map.get(targetChars[i]);
                frequency--;
                if(frequency==0) map.remove(targetChars[i]);
                else map.put(targetChars[i], frequency);

                result[i] = targetChars[i];
            }
            else {
                flag = false;
                char temp = 0;
                if(i==0) {
                    for (int j = 1; j + targetChars[i] <= 122; j++) {
                        if(map.containsKey((char) (j + targetChars[i]))) {
                            temp = (char) (j + targetChars[i]);
                            break;
                        }
                    }
                    if(temp != '\u0000') {
                        result[i] = temp;
                        int frequency = map.get(temp);
                        frequency--;
                        if(frequency==0) map.remove(temp);
                        else map.put(temp, frequency);
                    }
                } else {
                    temp = result[i-1];
                    if(map.containsKey(temp)) {
                        result[i] = temp;
                    } else {
                        for (int j = 1; j + targetChars[i] <= 122; j++) {
                            if(map.containsKey((char) (j + targetChars[i]))) {
                                temp = (char) (j + targetChars[i]);
                                break;
                            }
                        }
                    }
                    int frequency = map.get(temp);
                    frequency--;
                    if(frequency==0) map.remove(temp);
                    else map.put(temp, frequency);
                }
                System.out.print(temp);
                if(temp == '\u0000') return "";
                result[i] = temp;
            }
        }
        flag = true;
        for (int i = 0; i < result.length; i++) {
            if(result[i] > targetChars[i]) {flag = false; break;}
        }

        if(flag) return "";
        return new String(result);
    }
}
