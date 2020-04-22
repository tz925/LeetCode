package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class WordBreak {
    /*
    solution 1, backtracking with memo[array] caching to reduce search space
    n^3, bcuz substring takes n time. space n
    5ms 79.52% 40MB 5.08%
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper1(s, set, 0, new Boolean[s.length()]);
    }

    private boolean helper1(String s, Set<String> wordDict, int start, Boolean[] memo){
        if (start == s.length()) return true;
        if (memo[start] !=null) return memo[start];
        for (int end = start+1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && helper1(s, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    /*
    solution 2, BFS-like backtracking search with queue
    8ms 35.85% 39.5mb 5.08%
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int cur = 0;
        queue.offer(0);
        boolean[] visited = new boolean[s.length()];
        while(!queue.isEmpty()){
            cur = queue.poll();
            if (visited[cur]) continue;
            for (int i = cur+1; i <= s.length(); i++) {
                if (wordDict.contains(s.substring(cur, i))){
                    if (i == s.length()) return true;
                    queue.offer(i);
                }
            }
            visited[cur] = true;
        }
        return false;
    }

    /*
    solution 3, DP, build a dp[] with dp[i] = true means substring(0, i) can be composed by wordDict. bottom-up building
    n^3 time, n sapce
    6ms 68.55% 39.7mb 5.08%
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        return wordBreak3(s, new HashSet<>(wordDict));
    }

    public boolean wordBreak3(String s, Set<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
