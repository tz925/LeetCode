package com.Thomaszhou.sample;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "A man, a plan, a canal: Panama";
        s = s.replaceAll("[^\\w]", "");
        System.out.println(s);
        s = s.replaceAll("/s","");
        System.out.println(s);
        int a = 5;
        int b = a;
        b = 10;
        System.out.println(a);
        System.out.println(b);
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        image = FloodFill.floodFill(image, 1,1, 2);
        for(int[] i : image){
            for(int j : i){
                System.out.println(j);
            }
        }
        System.out.println("45: " +  5.0/3);

        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(1));
        System.out.println(cas.countAndSay(2));
        System.out.println(cas.countAndSay(3));
        System.out.println(cas.countAndSay(4));
        System.out.println(cas.countAndSay(5));
        System.out.println(cas.countAndSay(6));
        System.out.println(cas.countAndSay(7));
        System.out.println(cas.countAndSay(8));
        System.out.println(cas.countAndSay(9));
        System.out.println(cas.countAndSay(10));
    }
}
