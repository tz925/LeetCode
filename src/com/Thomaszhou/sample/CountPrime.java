package com.Thomaszhou.sample;

import java.util.Arrays;

public class CountPrime {
//    public int countPrimes(int n) {
//        int count = 0;
//        for(int i=1;i<n;i++){
//            System.out.println(Integer.toString(i) + isPrime(i));
//            if(isPrime(i)) count++;
//        }
//        return count;
//    }
//
//    private boolean isPrime(int x) {
//        if (x == 1) return false;
////        for(int i=2; i<=x;i++){
////        for(int i=2; i<=x/2;i++){
//            for(int i=2; i*i<=x ;i++){
//            if(x % i == 0 && x != i && i != 1) return false;
//        }
//        return true;
//    }

    // Sieve of Eratosthenes 
    public int countPrimes(int n){
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i<n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j+=i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
