package com.Thomaszhou.sample.Others;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*

 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(1);
            }
            for (int j = 1; j < i; j++) {
                row.set(j, triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
}
