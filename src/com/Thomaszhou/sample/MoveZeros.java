package com.Thomaszhou.sample;

public class MoveZeros {
    /*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/

    //Instead of trying to move 0s backward think about move non-0s forward.
    //When we Find a non-zero value, we swap it with last-seen zero
    public static void moveZeroes(int[] nums) {
        for(int lastZero = 0, cur = 0; cur < nums.length; cur++){
            if(nums[cur]!=0){
                int temp = nums[cur];
                nums[cur] = nums[lastZero];
                nums[lastZero] = temp;
                lastZero += 1;
            }
        }

    }
}
