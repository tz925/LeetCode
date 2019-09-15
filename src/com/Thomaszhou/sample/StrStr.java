package com.Thomaszhou.sample;

public class StrStr {
    public int strStr(String haystack, String needle){
        if (needle.isEmpty())return 0;

        int len = needle.length();
        String sub;

        for (int i = 0; i < haystack.length(); i++) {
            try{
                sub = haystack.substring(i,i+len);
            }catch(StringIndexOutOfBoundsException e){
                return -1;
            }
            if (haystack.substring(i,i+len).compareTo(needle) == 0) return i;
        }
        return -1;
    }
}
