package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */
public class LongestSubstringWIthAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> char2Index = new HashMap<>();
        int N = s.length(), maxLen = 0, l = 0, r = 0;
        while(r < N){
            char2Index.put(s.charAt(r), r++);

            if (char2Index.size() == k){
                int deleteIndex = Collections.min(char2Index.values());
                l = deleteIndex + 1;
                char2Index.remove(s.charAt(deleteIndex));
            }

            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }

    /*
    solution 2 with order Dictionary aka LinkedHashMap aka LRU cache.
     */
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int n = s.length();
        if (n*k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

        int max_len = 1;

        while (right < n) {
            Character character = s.charAt(right);
            // if character is already in the hashmap -
            // delete it, so that after insert it becomes
            // the rightmost element in the hashmap
            if (hashmap.containsKey(character))
                hashmap.remove(character);
            hashmap.put(character, right++);

            // slidewindow contains k + 1 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
                hashmap.remove(leftmost.getKey());
                // move left pointer of the slidewindow
                left = leftmost.getValue() + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}
