package com.Thomaszhou.sample.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) ans.add("");

        backTracking(ans, new StringBuilder(), 0,0, n);

        return ans;
    }

    private void backTracking(List<String> ans, StringBuilder tempSB, int opened, int closed, int n){
        if(opened == n && closed == n) ans.add(tempSB.toString()); //we have finished one.

        //ensure still valid while we add ( and ) to SB.
        //only add ( when we have enough closing to close it.
        if(opened < n){
            backTracking(ans, tempSB.append('('),opened+1,closed, n);
            tempSB.deleteCharAt(tempSB.length()-1);
        }

        //only add ) when we have opened more than closed.
        if(opened > closed) {
            backTracking(ans, tempSB.append(')'), opened, closed+1, n);
            tempSB.deleteCharAt(tempSB.length()-1);
        }
    }
}
