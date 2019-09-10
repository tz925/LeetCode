package com.Thomaszhou.sample;

import java.util.*;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.


 */


public class ValidParentheses {

    // time(n) space(n)
    public boolean isValid(String s){
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        Set<Character> left = new HashSet<>();
        left.add('(');left.add('{');left.add('[');
        char a = 'a';
        for(int i=0; i < s.length(); i++){
            a = s.charAt(i);
            if (left.contains(s.charAt(i))) {
                stack.push(a);
            }else{
                if (stack.empty()) return false;
                char b = stack.pop();
                if (a == ')' && b!='(') return false;
                else if (a == '}' && b!='{') return false;
                else if (a == ']' && b!='[') return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}
