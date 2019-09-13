package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length-1] != 9){
            digits[length-1] += 1;
            return digits;
        }else{//need to move on to more significant bits.
            boolean flag = true;
            int index = length-1;
            while(flag){
                if (digits[index] == 9){
                    digits[index] = 0;
                    index--;
                    if(index<0){ // When 9 is at the head of digits, we need a longer int[] to hold the leading 1.
                        int[] result = new int[length+1];
                        result[0] = 1;
                        for (int k = 0; k<length;k++){
                            result[k+1] = digits[k];
                        }
                        return result;
                    }
                }else{
                    digits[index] += 1;
                    flag = false;
                }
            }
            return digits;
        }
    }
}
