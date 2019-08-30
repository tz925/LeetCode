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
    }
}
