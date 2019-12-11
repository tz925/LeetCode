package com.Thomaszhou.sample.Math;
/*

 */
public class RomanToInteger {
    public int romanToInt(String s):
//            """
//        :type s: str
//        :rtype: int
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        """
    d = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
    max_i = len(s)-1
    result = 0
    copy = s[:]
//            # while(len(copy)!=0):
//            #     first = d[copy[0]]
//            #     if(len(copy)==1):
//            #         result += first
//        #         copy = ""
//            #     else:
//            #         second = d[copy[1]]
//            #         if(first>=second):
//            #             result += first
//        #             copy = copy[1:]
//            #         else:
//            #             result += (second - first)
//            #             copy = copy[2:]
            for i in range(len(copy)):
            if i < len(copy)-1 and d[copy[i]]<d[copy[i+1]]:
    result -= d[copy[i]]
            else:
    result += d[copy[i]]
            return result
}
