package com.Thomaszhou.sample.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

//return true if this NestedInteger holds a single integer, rather than a nested list.
public boolean isInteger();

 //@return the single integer that this NestedInteger holds, if it holds a single integer
// Return null if this NestedInteger holds a nested list
public Integer getInteger();

// @return the nested list that this NestedInteger holds, if it holds a nested list
 //Return null if this NestedInteger holds a single integer
public List<NestedInteger> getList();
 }

public class FlattenNestedListIterator implements Iterator<Integer> {
    private List<Integer> list;
    private Iterator<Integer> iter;

    private void decode(List<NestedInteger> nestedList){
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger ni = nestedList.get(i);
            if(ni.isInteger()){
                list.add(ni.getInteger());
            }else{
                decode(ni.getList());
            }
        }
    }

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        decode(nestedList);
        iter = list.iterator();
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */