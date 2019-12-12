package com.Thomaszhou.sample.ArrayAndStrings;
/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a'] += 1;
            count2[s2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
