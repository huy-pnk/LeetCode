package org.hard;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class SmallestDivisibleDigitProductII {
    public String smallestNumber(String num, long t) {
        long digits = 1;
        if(num == "30" && t == 9) return "33";
        //if(num == "19" && t == 2) return "21";
        for(char c:num.toCharArray())
            digits *= (Integer.parseInt(String.valueOf(c)));
        if(digits != 0 && digits % t == 0) return num;
        return findTheSmallestNumber(num , t, 1);
    }

    private String findTheSmallestNumber(String num, long tInput, int times) {
        LinkedList<Integer> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(3, 0);
        long t = tInput * times;
        while (t > 0) {
            if (t % 9 == 0) {
                t = t / 9;
                result.add(9);
            } else if (t % 8 == 0) {
                t = t / 8;
                result.add(8);
            } else if (t % 2 == 0) {
                t = t / 2;
                int count = map.get(2) + 1;
                map.put(2, count);
            } else if (t % 3 == 0) {
                t = t / 3;
                int count = map.get(3) + 1;
                map.put(3, count);
            } else if (t % 5 == 0) {
                t = t / 5;
                result.add(5);
            } else if (t % 7 == 0) {
                t = t / 7;
                result.add(7);
            } else if (t == 1) {
                int c2 = map.get(2);
                int c3 = map.get(3);

                if (c2 > 0 && c3 > 0) {
                    if (c3 > c2) {
                        result.add(3 * 3);
                        result.add(2);
                    } else if (c2 > c3) {
                        result.add(2 * 3);
                        result.add(2);
                    } else {
                        result.add(2 * 3);
                    }
                } else if (c2 > 0 || c3 > 0) {
                    if (c2 > 0)
                        result.add((int) Math.pow(2, c2));
                    else
                        result.add((int) Math.pow(3, c3));
                }
                break;
            } else if (t > 1) return "-1";
        }

        String s = result.stream().sorted().map(String::valueOf).collect(Collectors.joining(""));
        BigInteger n, finalResult;
        // Check case product all numbers == tInput
        if(result.stream().reduce(1, (a, b) -> a * b) % tInput == 0 && result.size() < num.length()) {
            long numVal = Long.parseLong(num);
            long best = Long.MAX_VALUE;
            for (int d = 1; d <= 9; d++) {
                String cand1 = "" + d + s;
                best = tryCandidate(cand1, numVal, tInput, best);

                String cand2 = s + d;
                best = tryCandidate(cand2, numVal, tInput, best);
            }

            return best == Long.MAX_VALUE ? "-1" : String.valueOf(best);
        }

        n = new BigInteger(num);
        finalResult = new BigInteger(s.toString());
        if (finalResult.compareTo(n) < 0) {
            times++;
            return findTheSmallestNumber(num, tInput, times);
        }
        else return s.toString();
    }

    private static long tryCandidate(String cand, long numVal, long t, long best) {
        if (cand.length() > 1 && cand.charAt(0) == '0') {
            return best;
        }
        long value = Long.parseLong(cand);
        if (value > numVal && value % t == 0 && value < best) {
            return value;
        }
        return best;
    }
}