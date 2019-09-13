package com.Thomaszhou.sample;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.


 */
public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder last = new StringBuilder("1");
        StringBuilder cur = new StringBuilder();
        if (n == 1) return last.toString();
        for (int i = 1; i < n; i++) { // do it n - 1 times.
            char lastseen = '!';
            int count = 0;
            for(int j=0; j<last.length(); j++){ //看到一个不一样的 如果上一个看到了超过0次 就吧count和上一个看到的东西输入进去 同时清0count 清空Last seen
                char seeing = last.charAt(j);
                if (seeing == lastseen){
                    count++;
                }else{
                    if (count != 0){
                        cur.append(count);
                        cur.append(lastseen);
                    }
                    lastseen = seeing;
                    count = 1;
                }
            }
            cur.append(count);
            cur.append(lastseen);
            last = new StringBuilder(cur.toString());
            cur.delete(0,cur.length());
            lastseen = '!'; //reset
            count = 0; // reset
        }
        return last.toString();
    }
}