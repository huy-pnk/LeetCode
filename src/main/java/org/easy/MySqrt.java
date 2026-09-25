package org.easy;

/**
 * 69. Sqrt(x)
 * <a href="https://leetcode.com/problems/sqrtx/description/">...</a>
 */
public class MySqrt {
    public int mySqrt(int x) {
        if(x== 1) return 1;
        if(x==0) return 0;
        int num = 46340;
        if(x/2 >= num) {
            for(int i=num; i >= 0; i--) {
                if(i*i == x) return i;
                else if(((i-1) * (i-1) < x) && i*i>x) {return i-1;}
                else if(((i-1) * (i-1) < x)) {return i;}
            }
        }  else {
            for(int i=x/2; i >= 0; i--) {
                if(i*i == x) return i;
                else if(((i-1) * (i-1) < x) && i*i>x) {return i-1;}
                else if(((i-1) * (i-1) < x)) {return i;}
            }
        }

        return 0;
    }
}
