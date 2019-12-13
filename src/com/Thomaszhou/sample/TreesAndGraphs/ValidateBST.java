package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.LinkedList;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBST {
    // Recursive
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }
//
//    private boolean helper(TreeNode root, Integer upper, Integer lower){
//        if (root == null) return true;
//
//        int val = root.val;
//
//        if (lower != null && val <= lower) return false;
//        if (upper != null && val >= upper) return false;
//
//        if (!helper(root.left, val, lower)) return false;
//        if (!helper(root.right, upper, val)) return false;
//
//        return true;
//    }

    // Iterative
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

}
