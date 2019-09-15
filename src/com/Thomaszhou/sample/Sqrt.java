package com.Thomaszhou.sample;

public class Sqrt {
    // binary search
    public int sqrt(int x){
        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid;
        while(true){
            mid  = left + (right - left) /2;
            if(mid > x/mid){
                right = mid - 1;
            }else{
                if (mid+1 > x/(mid+1)){
                    return mid;
                }
                left = mid + 1;
            }
        }
    }
}
