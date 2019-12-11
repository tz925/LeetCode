package com.Thomaszhou.sample.Others;

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
/*
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    } */
}
