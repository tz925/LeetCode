package com.Thomaszhou.sample;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        String s = "A man, a plan, a canal: Panama";
//        s = s.replaceAll("[^\\w]", "");
//        System.out.println(s);
//        s = s.replaceAll("/s","");
//        System.out.println(s);
//        int a = 5;
//        int b = a;
//        b = 10;
//        System.out.println(a);
//        System.out.println(b);
//        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        image = FloodFill.floodFill(image, 1,1, 2);
//        for(int[] i : image){
//            for(int j : i){
//                System.out.println(j);
//            }
//        }
//        System.out.println("45: " +  5.0/3);

        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(4,7));

    }
}
