package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/discuss/34538/My-Accepted-Java-Solution
 */
public class ConstructBinaryTreeFromPreorderInorder {
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(0,0,inorder.length-1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if (preStart > preorder.length-1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        int numsLeft = inIndex - inStart;

        root.left = helper(preStart+1, inStart, inIndex -1, preorder, inorder);
        root.right = helper(preStart+numsLeft+1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
