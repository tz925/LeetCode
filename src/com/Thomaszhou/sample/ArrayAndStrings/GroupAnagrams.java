package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    // use list of sorted char as key.
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<List<Character>, List<String>> map = new HashMap<>();
        // map char list to list of string
        for(int i = 0; i < strs.length; i++){
            List<Character> charList = new ArrayList<>();
            for(int j = 0; j < strs[i].length(); j++){
                charList.add(strs[i].charAt(j));
            }
            Collections.sort(charList);
            List<String> tempList = map.getOrDefault(charList, new ArrayList<>());
            tempList.add(strs[i]);
            map.put(charList, tempList);
        }
        for (List<String> temp: map.values()){
            result.add(temp);
        }
        return result;
    }
    */

    // uses string as key not much faster...
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//        // map char list to list of string
//        for(int i = 0; i < strs.length; i++){
//            int[] storeCharCount = new int[26];
//            String s = strs[i];
//            for (int j = 0; j < s.length(); j++) {
//                storeCharCount[s.charAt(j)-'a']++;
//            }
////            String key = storeCharCount.toString(); => memory address
//            String key = Arrays.toString(storeCharCount); // => readable string representation.
//            List<String> tempList = map.getOrDefault(key, new ArrayList<>());
//            tempList.add(s);
//            map.put(key, tempList);
//        }
//        for (List<String> temp: map.values()){
//            result.add(temp);
//        }
//        return result;
//    }

    //use hashcode as key, hash function takes constant time. beat 96%, 8ms
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        // map char list to list of string
        for(int i = 0; i < strs.length; i++){
            int[] storeCharCount = new int[26];
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                storeCharCount[s.charAt(j)-'a']++;
            }
            int key = Arrays.hashCode(storeCharCount);
            List<String> tempList = map.getOrDefault(key, new ArrayList<>());
            tempList.add(s);
            map.put(key, tempList);
        }
        for (List<String> temp: map.values()){
            result.add(temp);
        }
        return result;
    }

}
