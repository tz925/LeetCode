package com.Thomaszhou.sample.DynamicProgramming;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
class DecodeWays {

    Integer[] memo;

    private int recursiveWithMemo(int index, String str) {

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length()-1) {
            return 1;
        }

        // Memoization is needed since we might encounter the same sub-string.
        if (memo[index] != null) {
            return memo[index];
        }

        int ans = recursiveWithMemo(index+1, str);
        if (Integer.parseInt(str.substring(index, index+2)) <= 26) {
            ans += recursiveWithMemo(index+2, str);
        }

        // Save for memoization
        memo[index] = ans;

        return ans;
    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        memo = new Integer[s.length()];
        return recursiveWithMemo(0, s);
    }

    /*
    solution2 iterative
     */
    private int[] dp;
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') return 0;

        dp = new int[s.length()+1]; // dp[i] = ways to decode the substring from index 0 to i-1.
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            //check if single digit is possible at i - 1.
            if(s.charAt(i-1) != '0') dp[i] += dp[i-1];

            // check if double digit is possible with substring(i-2,i)
            int value = Integer.parseInt(s.substring(i-2, i));
            if(value >= 10 && value <= 26) dp[i] += dp[i-2];

        }

        return dp[s.length()];

    }

    /*
    solution 3 with two prev pointers
     */

    public int numDecodings3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[3]; // dp[0] = dp[i-2] dp[1] = dp[i-1] dp[2] = dp[i];
        dp[0] = 1; // empty string has 1 way to decode
        dp[1] = 1; // since s[0] is not 0, substring(0,1) has 1 way to decode.

        for (int i = 2; i < s.length()+1; i++) {
            dp[2] = 0;
            //check if single digit is possible at i - 1.
            if(s.charAt(i-1) != '0') dp[2] += dp[1];

            // check if double digit is possible with substring(i-2,i)
            int value = Integer.parseInt(s.substring(i-2, i));
            if(value >= 10 && value <= 26) dp[2] += dp[0];

            dp[0] = dp[1];
            dp[1] = dp[2];

        }

        return dp[s.length()];

    }

}
