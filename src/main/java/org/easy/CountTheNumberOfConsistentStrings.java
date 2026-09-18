package org.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> input = toHashSet(allowed);
        for(String word : words) {
            char[] temp = word.chars().distinct().sorted().mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining())
                    .toCharArray();
            if(isConsistent(input, temp)) count++;
        }
        return count;
    }


    public boolean isConsistent(Set<Character> input, char[] temp) {
        for(char c : temp) {
            if(!input.contains(c)) {
                return false;
            }
        }
        return true;
    }
    public Set<Character> toHashSet(String a) {
        Set<Character> temp = new HashSet<>();
        for(char c : a.toCharArray()) {
            temp.add(c);
        }
        return temp;
    }
}
