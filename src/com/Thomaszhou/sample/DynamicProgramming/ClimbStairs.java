package com.Thomaszhou.sample.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {
    public int climbStairs(int n) {
        // total ways = #ways if we take 1 step + #ways if we take 2 steps
        // T(n) = T(n - 1) + T(n - 2)
        // basically Fibonacci Numbers. find out base case value and we can get answer.
        // Time(n) Space(1)

        if(n == 1) return 1;
        if(n == 2) return 2;
        int p1 = 1;
        int p2 = 2;
        int ans = 0;
        for(int i = 3; i <=n; i++){
            ans = p1+p2;
            p1 = p2;
            p2 = ans;
        }
        return ans;
    }
}
