package com.Thomaszhou.sample.ArrayAndStrings;

public class PalindromeII {
    //Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
    public static Boolean validPalindrome(String s){
        for (int i = 0; i< s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return isPalindrome(s,i+1, s.length()-1-i) || isPalindrome(s, i, s.length()-1-i-1);
            }
        }
        return true;
    }

    public static Boolean isPalindrome(String s, int start, int stop){
        while(start<stop){
            if (s.charAt(start)!=s.charAt(stop)){
                return false;
            }
            start++;
            stop--;
        }
        return true;
    }
}
