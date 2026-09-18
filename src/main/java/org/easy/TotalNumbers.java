package org.easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 3483. Unique 3-Digit Even Numbers
 * https://leetcode.com/problems/unique-3-digit-even-numbers/
 */
public class TotalNumbers {
    public int totalNumbers(int[] digits) {
        if(digits == null || digits.length == 0) return 0;

        int[] evenNumbers = new int[digits.length];
        int countEvenNumber = 0;
        // check even number
        for (int i = 0; i < digits.length; i++) {
            if(digits[i] % 2 == 0) {
                evenNumbers[countEvenNumber] = i;
                countEvenNumber++;
            }
        }
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            int indexOfThirdNumber = 0;
            if(digits[i] > 0) {
                while(indexOfThirdNumber < countEvenNumber) {
                    int indexOfSecondNumber = 0;
                    while (indexOfSecondNumber < digits.length) {
                        if(indexOfSecondNumber != i &&
                                indexOfSecondNumber != evenNumbers[indexOfThirdNumber] &&
                                i != evenNumbers[indexOfThirdNumber]) {
                            String temp = String.valueOf(digits[i]) + digits[indexOfSecondNumber] + digits[evenNumbers[indexOfThirdNumber]];
                            stringSet.add(temp);
                        }
                        indexOfSecondNumber++;
                    }
                    indexOfThirdNumber++;
                }

            }
        }
        return stringSet.size();
    }
}
