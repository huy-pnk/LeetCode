package org.medium;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1927. Sum Game
 * https://leetcode.com/problems/sum-game/
 */
public class SumGame {
    public boolean sumGame(String num) {
        // true - Alice - false Bob
        boolean turn = true;
        char[] array = num.toCharArray();
        int alice = 0;
        int bob = 0;
        int half = array.length/2;
        int index = 0;
        int[] questionArray = new int[num.length()];
        int indexQuestionArray = 0;
        for (char c : array) {
            if(c == '?') {
                questionArray[indexQuestionArray] = index;
                indexQuestionArray++;
            }
            if(index < half && c != '?') {
                // sum for A;
                alice += Character.getNumericValue(c);
            } else if(index >= half && c != '?'){
                bob += Character.getNumericValue(c);
            }
            index++;
        }
        int step = 1;
        int numberOfQuestion = indexQuestionArray;
        indexQuestionArray--;
        int i = 0;
        while(step <= numberOfQuestion) {
            if(turn) {
                if(i == 0 && array[i] == '?') {
                    int temp =  (Math.abs(bob-alice) % 9) + 1;
                    array[i] = (char)('0' + temp);
                    alice += temp;
                    i++;
                } else {
                    int temp =  (Math.abs(bob-alice) % 9) + 1;
                    array[questionArray[i]] = (char)('0' + temp);
                    if(questionArray[i] >= half) bob += temp;
                    else alice += temp;
                    i++;
                }
            } else {
                int temp;
                temp =  Math.abs(bob-alice);
                if(temp > 9) temp = temp % 9;
                array[questionArray[indexQuestionArray]] = (char)('0' + temp);
                if(questionArray[indexQuestionArray] >= half) bob += temp;
                else alice += temp;
                indexQuestionArray--;
            }
            turn = !turn;
            step++;
        }

        return !(alice == bob);
    }
}



//        for (int i = 0; i < questionArray.length; i++) {
//            // Alice turn
//            if(i == 0 && array[i] == '?') {
//                int temp =  (Math.abs(bob-alice) + 1);
//                temp = Math.min(temp, 9);
//                array[i] = (char)('0' + temp);
//                alice += temp;
//            } else if(questionArray[i] > 0) {
//                // Alice
//                if(turn) {
//                    int temp =  (Math.abs(bob-alice) +  1);
//                    temp = temp > 9 ? temp-9 : temp;
//                    array[questionArray[i]] = (char)('0' + temp);
//                    if(questionArray[i] >= half) bob += temp;
//                    else alice += temp;
//                } else {
//                    int temp;
//                    // if bob turn but in range of Alice
//                    if(questionArray[i] < half) {
//                        temp = 0;
//                    } else {
//                        temp =  (Math.abs(bob-alice));
//                        temp = Math.min(temp, 9);
//                    }
//                    array[questionArray[i]] = (char)('0' + temp);
//                    if(questionArray[i] >= half) bob += temp;
//                    else alice += temp;
//                }
//            } else if(i > 0 && questionArray[i] == 0) {
//                break;
//            }
//            turn = !turn;
//        }
//        System.out.println(array);
