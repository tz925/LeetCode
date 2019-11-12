package com.Thomaszhou.sample;

import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class letterCombinations {
    private static Map<Character, List<String>> d2l = new HashMap<>();
    static {
        d2l.put('2', new ArrayList<String>(Arrays.asList("a","b","c")));
        d2l.put('3', new ArrayList<String>(Arrays.asList("d","e","f")));
        d2l.put('4', new ArrayList<String>(Arrays.asList("g","h","i")));
        d2l.put('5', new ArrayList<String>(Arrays.asList("j","k","l")));
        d2l.put('6', new ArrayList<String>(Arrays.asList("m","n","o")));
        d2l.put('7', new ArrayList<String>(Arrays.asList("p","q","r","s")));
        d2l.put('8', new ArrayList<String>(Arrays.asList("t","u","v")));
        d2l.put('9', new ArrayList<String>(Arrays.asList("w","x","y","z")));
    }
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        StringBuilder input = new StringBuilder(digits);
        StringBuilder temp = new StringBuilder();

        backTracking(input, temp, result, 0);

        return result;
    }

    private void backTracking(StringBuilder input, StringBuilder temp, List<String> result, int at){
        if(at == input.length()) {
            result.add(temp.toString());
            return;//base case
        }

        Character curChar = input.charAt(at);
        List<String> letters = d2l.get(curChar);
        for (int i = 0; i < letters.size(); i++) {
            temp.append(letters.get(i));
            backTracking(input, temp, result, ++at);
            at--;
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
