package com.Thomaszhou.sample.Math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // O(steps) time O(steps) space
//    public boolean isHappy(int n) {
//        if (n <= 0) return false;
//        Set<Integer> set = new HashSet<>();
//        while (n != 1){
//            n = hap(n);
//            if (set.contains(n)) return false;
//            else set.add(n);
//        }
//        return true;
//    }

    // Constant space, just like linkedList detect cycle fast and slow method.
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while(slow != 1){
            slow = hap(slow);
            if (slow == 1) return true;
            fast = hap(hap(fast));
            if (fast == 1) return true;

            if (slow == fast) return true;
        }
        return true;
    }

    public int hap(int n) {
        int result = 0;
        while(n > 0){
            int digit = n % 10;
            result += digit*digit;
            n /= 10;
        }
        return result;
    }
}
