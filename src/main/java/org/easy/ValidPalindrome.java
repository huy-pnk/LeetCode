package org.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String input = s.toLowerCase().replaceAll("[^ -~]", "");
        int i = 0, j =input.length() -1;
        while(i<=j) {
            if(input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
