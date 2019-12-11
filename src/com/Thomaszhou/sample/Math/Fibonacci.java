package com.Thomaszhou.sample.Math;

class Fibonacci {
    public static int fib(int N) {
        if (N<=1){return N;}
        // return fib(N-1) + fib(N-2);

        // time n space n
        // int[] fibs = new int[N+1];
        // fibs[0] = 0;
        // fibs[1] = 1;
        // for(int i=2;i<=N;i++){
        //     fibs[i] = fibs[i-1]+fibs[i-2];
        // }
        // return fibs[N];

        // time n space 1
        int prev1 = 0;
        int prev2 = 1;
        int cur = 0;
        for(int i = 2; i<=N;i++){
            cur = prev1+prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
}