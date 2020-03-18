package com.Thomaszhou.sample.DynamicProgramming;
/*
Input:

n = 3
x = [7,3,5,9,1,2]
You need to split the array x into n consecutive subarrays. For example, you can split x into
[7,3], [5,9], [1,2] or [7,3,5], [9], [1,2]. But you cannot split x into [7,5,9], [3], [1,2] because [7,5,9]is not consecutive.

You should output the minimum maximum sum of every subarrays.

In this case, the output is 12:
[7,3], [5], [9,1,2] or [7], [3,5], [9,1,2]
 */
public class MinimumSumOfSubarrayAmazon {
    public static void main(String[] args) {
        int[] nums = {7,3,5,9,1,2};
        int n = 3;
        System.out.println(solve(nums, n));
    }

    private static int solve(int[] nums, int n) {
        if(n > nums.length) // 检查如果n比总长度还长 设置回length 不然做不了
            n = nums.length;

        //建一个 (分组数+1) * (总长度+1)的 matrix
        // 例子里面的话 相当于一个 4 * 7 matrix
//        [
//                [0,1,2,3,4,5,6],
//                [],
//                [],
//                []
//        ]
        int[][] dp = new int[n+1][nums.length + 1];

        //给第一行传入max
        for(int i=1;i<=nums.length;i++)
            dp[0][i] = Integer.MAX_VALUE;
//        [
//                [MAX,MAX,MAX,MAX,MAX,MAX,MAX],
//                [0,7,10,15,24,25,27]
//                [null,7,7,null,null,null,null],
//                [null,null,null,null,null,null,null]
//        ]

        int sum = 0;
        for(int k=1;k<=n;k++) {
            //k = 1,2,3
            for(int i=1;i<=nums.length;i++) {
                // i=1,2,3,4,5,6
                sum = 0;
                dp[k][i] = Integer.MAX_VALUE;
                for(int j=i;j>=0;j--) {
                    dp[k][i] = Math.min(dp[k][i], Math.max(dp[k-1][j], sum));
                    if(j > 0)
                        sum += nums[j-1];
                    StringBuilder sb = new StringBuilder();
                    for (int l = 0; l < n+1; l++) {
                        sb.append("[");
                        for (int m = 0; m < nums.length+1; m++) {
                            sb.append(dp[l][m]+",");
                        }
                        sb.append("]\n");
                    }
                    sb.append("sum: "+sum+"\n");
                    System.out.println(sb.toString());
                }
            }
        }
        return dp[n][nums.length];
    }
}
