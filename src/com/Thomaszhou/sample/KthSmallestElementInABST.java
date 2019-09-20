package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> smallElements = inorderTraversal(root, k);

        return smallElements.get(k-1);
    }

    // this inOrderTraversal is okay but I want something faster without unneeded steps.
    /*
    private List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

     */

    private List<Integer> inorderTraversal(TreeNode root, int k){
        List <Integer> res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while ((curr != null || !stack.isEmpty())&& res.size()<k) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
