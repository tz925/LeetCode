package com.Thomaszhou.sample;

import java.util.HashMap;
import java.util.Map;

/*
Replace certain letters with the mapping below:
[a,A] -&gt; 4
[e,E] -&gt; 3
[i,I] -&gt; 1
[o,O] -&gt; 0
[s,S] -&gt; 5
[t,T] -&gt; 7
[b,D] -&gt; 5

Examples
Let&#39;s have some fun. -&gt; L37&#39;5 h4v3 50m3 fun.
C is for cookie, that&#39;s good enough for me -&gt; C 15 f0r c00k13, 7h47&#39;5 g00d 3n0ugh f0r m3
By the power of Grayskull! -&gt; By 7h3 p0w3r 0f Gr4y5kull!
 */
public class Prodigy {
    private static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('a', 4);
        map.put('e', 3);
        map.put('i', 1);
        map.put('o', 0);
        map.put('s', 5);
        map.put('t', 7);
        map.put('A', 4);
        map.put('E', 3);
        map.put('I', 1);
        map.put('O', 0);
        map.put('S', 5);
        map.put('T', 7);
        map.put('b', 5);
        map.put('D', 5);
    }

    public static void main(String[] args) {
        String input = "By the power of Grayskull!";
        System.out.println(lettersToLeet(input));
    }

    public static String lettersToLeet(String s) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer r = map.getOrDefault(c, -1);
            if (r != -1){
                s = s.replace(c, r.toString().charAt(0));
            }
        }
        return s;
    }
}


