package org.easy;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        long revnum = 0;
        if(x < 0)
            return false;
        if(x == 0)
            return true;
        int temp = x;
        while (x != 0) {
            revnum = revnum * 10 + (x % 10);
            x /= 10;
        }

        if(revnum > Integer.MAX_VALUE)
            return false;
        if(revnum == temp)
            return true;
        return false;
    }
}
