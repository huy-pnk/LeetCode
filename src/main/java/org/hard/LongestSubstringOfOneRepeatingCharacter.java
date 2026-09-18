package org.hard;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 2213. Longest Substring of One Repeating Character
 * https://leetcode.com/problems/longest-substring-of-one-repeating-character/description/?envType=daily-question&envId=2026-08-13
 */
public class LongestSubstringOfOneRepeatingCharacter {


//    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//        char[] sCharArray = s.toCharArray();
//        char[] queryCharactersArray = queryCharacters.toCharArray();
//        for(int i=0; i<queryIndices.length; i++) {
//            //sCharArray
//        }
//    }
//
//    private Map<Integer, Integer> managementMap(char[] input) {
//        HashMap<Character, CharacterManagement> result = new HashMap<>();
//        for(int i=0;i<input.length; i++) {
//            CharacterManagement characterManagement = null;
//            if(result.containsKey(input[i])) {
//                int count =  result.get(i).count + 1;
//                int startIndex = result.get(i).startIndex;
//                characterManagement = new CharacterManagement(startIndex, count);
//            } else {
//                characterManagement = new CharacterManagement(i, 1);
//            }
//            result.put(input[i], characterManagement);
//        }
//        return result;
//    }
}
