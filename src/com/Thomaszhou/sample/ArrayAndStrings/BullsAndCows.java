package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1#23", guess = "0#11"

1 -> 2
0 -> 1
# -> 1

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        // 10ms 2 pass
//        char[] s = secret.toCharArray();
//        char[] g = guess.toCharArray();
//        for (int i = 0; i < g.length; i++) {
//            if (s[i] == g[i]){
//                bull++;
//                s[i] = '#';
//                g[i] = '#';
//            }
//        }
//
//        //剩下的数出来数量放Map， 然后有对应的就-1
//        Map<Character, Integer> c2i = new HashMap<>();
//        for (int i = 0; i < g.length; i++) {
//            char c = g[i];
//            c2i.put(c, c2i.getOrDefault(c, 0)+1);
//        }
//
//        if (bull != 0) {
//            c2i.put('#', 0);
//        }
//
//        for (int i = 0; i < s.length; i++) {
//            char c = s[i];
//            int count = c2i.getOrDefault(c, 0);
//            if (count > 0) {
//                c2i.put(c, count - 1);
//                cow++;
//            }
//        }
//
//        StringBuilder ans = new StringBuilder();
//        ans.append(bull);
//        ans.append('A');
//        ans.append(cow);
//        ans.append('B');
//
//        return ans.toString();

        // one pass
        int[] numbers = new int[10]; // to store occurence
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bull++;
            else {
                if (numbers[s] < 0) cow++;
                if (numbers[g] > 0) cow++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bull + "A" + cow + "B";
    }
}
