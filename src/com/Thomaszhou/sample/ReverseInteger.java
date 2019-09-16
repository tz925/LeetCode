package com.Thomaszhou.sample;

public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;
        while(x!=0){
            int last_digit = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && last_digit > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && last_digit < -8)) return 0;
            reverse = reverse*10 + last_digit;
        }
        return reverse;
    }

}
