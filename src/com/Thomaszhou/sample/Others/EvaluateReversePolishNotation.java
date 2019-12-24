package com.Thomaszhou.sample.Others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {
    static final String[] dg = new String[] {"1","2","3","4","5","6","7","8","9","0"};
    static final Set<String> dgset = new HashSet<>(Arrays.asList(dg));

    public int evalRPN(String[] tokens) {
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (cur == "+" || cur == "-" || cur == "*" || cur == "/"){
                result = helper(tokens, i);
            }
        }
        return result;
    }

    public int helper(String[] tokens, int opInd) {

        int first = getPrevNum(tokens, opInd - 1);
        int second = getPrevNum(tokens, opInd - 2);
        int result = 0;
        String operator = tokens[opInd];
        if (operator == "+") result = first + second;
        else if (operator == "-") result = first - second;
        else if (operator == "*") result = first * second;
        else if (operator == "/") result = first / second;

        tokens[opInd] = Integer.toString(result);
        return result;

    }

    public int getPrevNum(String[] tokens, int start) {
        while(!dgset.contains(tokens[start])){
            start--;
        }
        String temp = tokens[start];
        tokens[start] = "#";
        return Integer.parseInt(temp);
    }
}
