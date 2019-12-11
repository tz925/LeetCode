package com.Thomaszhou.sample.ArrayAndStrings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder answer = new StringBuilder();

        int curIndex = 0;
        while(curIndex < strs[0].length()){// prefix is not going to be longer than strs[0], when strs[0] is really long error catch handles.
            char cur = strs[0].charAt(curIndex);
            for (int j = 1; j < strs.length; j++) {
                char c;
                try{
                    c = strs[j].charAt(curIndex);
                }catch (StringIndexOutOfBoundsException e){
                    return answer.toString();
                }
                if (c != cur) return answer.toString();
            }
            answer.append(cur);
            curIndex++;
        }

        return answer.toString();
    }
}
