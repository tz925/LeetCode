package com.Thomaszhou.sample;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        double f = n;
        while(f >= 3){
            f = f/3;
        }
        return f==1? true:false;
    }

//    public boolean isPowerOfThree(int n) {
//        return n > 0 && 1162261467 % n == 0;
//    }
}
