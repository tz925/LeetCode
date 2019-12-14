package com.Thomaszhou.sample.Design;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> stack;
    List<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();

        min = new ArrayList<>();
        min.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.add(x);
        int prevMin = min.get(min.size()-1);
        if ((x < prevMin)) {
            min.add(x);
        } else {
            min.add(prevMin);
        }

    }

    public void pop() {
        int s = stack.remove(stack.size()-1);
        System.out.println("s"+s);
        int x = min.remove(min.size()-1);
        System.out.println("m"+x);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return min.get(min.size()-1);
    }
}
