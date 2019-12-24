package com.Thomaszhou.sample.Math;
/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean sign = (dividend < 0) == (divisor < 0);
        dividend = dividend > 0? -dividend: dividend;
        divisor = divisor > 0? -divisor: divisor;
        int res = div(dividend, divisor);
        return sign? res: -res;
    }

    public int div(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int curSum = divisor*2, prevSum = divisor, q = 1;

        while(dividend <= curSum && curSum < prevSum){
            prevSum = curSum;
            curSum +=curSum;
            q += q;
        }
        return q + div(dividend - prevSum, divisor);
    }
}
