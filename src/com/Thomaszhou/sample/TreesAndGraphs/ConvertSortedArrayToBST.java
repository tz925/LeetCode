package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.Arrays;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //get middle, make it node, then node.left(right) is left(right) part of array recursive.
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end){
        int mid;
        if ((end - start) > 0) mid = (end - start) /2 + start;
        else return null;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, start, mid);
        node.right = helper(nums, mid+1, end);

        return node;
    }

}
