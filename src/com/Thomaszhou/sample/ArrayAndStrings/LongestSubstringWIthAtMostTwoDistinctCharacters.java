package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringWIthAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> char2Index = new HashMap<>(); // map char to last seen position.
        int l = 0, r = 0, maxLen = 0, N = s.length(), curLen = 0;
        while(r < N){
            char curChar = s.charAt(r);
            char2Index.put(curChar, r++); // putting last seen char at r, at the same time r += 1.

            if (char2Index.size() == 3) { //we have too many distinct character.

                //find the least recent seen char, move l to its position + 1, remove this char from map.
                int deleteIndex = Collections.min(char2Index.values());
                l = deleteIndex + 1;
                char2Index.remove(s.charAt(deleteIndex));
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
