package org.easy;

public class CheckDivisibility {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;
        while(temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            sum += digit;
            product *= digit;
        }

        return n % (sum + product) == 0;
    }
}
