package com.Thomaszhou.sample.ArrayAndStrings;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class TrappingRainWater {
    /*
    solution 1 dp, use int[] maxLeft and maxRight to record highest bar to the left and right from index i (including height[i])
    then ans+= (min(maxLeft[i], maxRight[i]) - height[i] if > 0)
     */
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        //get max left
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }

        //get max right
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        //get answer
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return ans;
    }

    /*
    2 pointer solution.
    intuition: when left is lower than right, how much water trapped only depends on leftMax (because we know right max
    is at least as high as leftMax,) vice versa.
     */

    public int trap2(int[] height){
        int l = 0, r = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int ans = 0;
        while(l < r){
            if (height[l] < height[r]){
                if (height[l] >= maxLeft){
                    maxLeft = height[l];
                }else{
                    ans += maxLeft - height[l];
                }
                l++;
            }
            else{ // height[l] >= height[r]
                if (height[r] >= maxRight){
                    maxRight = height[r];
                }else{
                    ans += maxRight - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
