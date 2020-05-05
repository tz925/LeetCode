package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    /*
    solution 1, use sliding window.
    we have int l, r for marking the border of window. int formed to track how many char in T we have satisfied.
    int required to record total number of character we need to fulfill

    We first count the occurence of letters in T, record in a HashMap.

    Then we use sliding window, expand if we need more character to make formed = required. once formed = required,
    we record the length, and keep move l towards end (removing chatacter from sliding window) and update the minLength,
    until formed more longer = required (formed != required), then we do r++ to move on again trying to make window valid.

    when r hits the end of S, we return the result.

    time(|S| + |T|) we go through S at most twice, and T once.
    space (|S| + |T|) we store two hashtables and some pointers.

    LC 15ms 32.24% 40.5MB 23.41%

     */

    /*
    solution 2, use sliding window. just like solution 1, but we filter the input S first before we process it. This
    will speed up cases where we have a large length of S, with most of it irrelevant to T, and a small T.

    Time (|S| + |filtered S| + |T|)
    space(|filtered S| + |T|)

    consider case: S = "AAAAAAAAAAAAAAAAAAAAAAAAB" (20A and 1B) T = "B"

    solution 1 will be going (|21| * 2 + |T|) = 43
    solution 2 will be going (|21| + |1| + |T|) = 23

    but in case: S = "BAAAAAAAAAAAAAAAAAAAAAAA" (1B and 20A) T = "AAAAAAAAAAAAAAAAAAAAAA"(20A)
    solution 1 : (|21| + |1| for get rid of B + |T|) = 42
    solution 2 : (|21| filtering + |20| for filtered S + |T|) = 61

    LC: 14 ms, faster than 40.11% of Java online submissions for Minimum Window Substring.
    Memory Usage: 45.7 MB, less than 5.32%

     */

    /* actually after I get rid of the Pair() in LC's solution, and used int[] to store index mapping from filtered S
     to original index, I got a performance gain.
     Runtime: 12 ms, faster than 55.90% of Java online submissions for Minimum Window Substring.
     Memory Usage: 41.2 MB, less than 18.09% of Java online submissions for Minimum Window Substring.

    */
    public String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        StringBuilder filteredS = new StringBuilder();
        int[] filteredIndexes = new int[s.length()]; // to record the true index of filtered S
        int q = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.append(c);
                filteredIndexes[q++] = i;
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.length()) {
            char c = filteredS.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.charAt(l);

                // Save the smallest window until now.
                int end = filteredIndexes[r];
                int start = filteredIndexes[l];
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    /*
        huge performance gain from using char[] and int[] for String and Map
        Runtime: 2 ms, faster than 99.99% of Java online submissions for Minimum Window Substring.
        Memory Usage: 40.1 MB, less than 30.85% of Java online submissions for Minimum Window Substring.
    */
    public String minWindow1(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < t_array.length; i++)
            map[t_array[i]] ++;
        int count = t_array.length;
        int min_start = 0;
        while(end < s_array.length)
        {
            if(map[s_array[end]] > 0)
            {
                count--;
            }
            map[s_array[end]] --;
            while(count == 0)
            {
                if((end - start + 1) < min_length)
                {
                    min_length = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]] ++;
                if(map[s_array[start]] > 0){
                    count ++;
                }
                start++;
            }
            end ++;

        }
        if( min_start+min_length > s_array.length)
            return "";
        return s.substring(min_start, min_start+min_length);
    }
}

