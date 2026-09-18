package org.hard;

public class MaxPalindromes {

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (j > i) {
            if(chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public int maxPalindromes(String s, int k) {
        if(k==1) return s.length();
        int result = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        int n = chars.length;
        while (i <= n - k) {
            if (isPalindrome(chars, i, i + k - 1)) {
                result++;
                i += k;
            }
            else if (i + k < n && isPalindrome(chars, i, i + k)) {
                result++;
                i += k + 1;
            }
            else {
                i++;
            }
        }
        return result;
    }
}

// fttf
//
