package com.Thomaszhou.sample.TreesAndGraphs;


import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

public class MergeBinaryTrees {
//    Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//
//    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
//
//            Example 1:
//
//    Input:
//    Tree 1                     Tree 2
//            1                         2
//            / \                       / \
//            3   2                     1   3
//            /                           \   \
//            5                             4   7
//    Output:
//    Merged tree:
//            3
//            / \
//            4   5
//            / \   \
//            5   4   7
//
//
//    Note: The merging process must start from the root nodes of both trees.

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        //Recursive way
        TreeNode newT = null;
        if (t1 instanceof TreeNode && t2 instanceof TreeNode){
            newT = new TreeNode(t1.val + t2.val);
            newT.left = mergeTrees(t1.left,t2.left);
            newT.right = mergeTrees(t1.right,t2.right);
        }else if (t1 instanceof TreeNode) {
            newT = new TreeNode(t1.val);
            newT.left = mergeTrees(t1.left,null);
            newT.right = mergeTrees(t1.right,null);
        }else if (t2 instanceof TreeNode){
            newT = new TreeNode(t2.val);
            newT.left = mergeTrees(null,t2.left);
            newT.right = mergeTrees(null,t2.right);
        }else{
            newT = null;
        }
        return newT;

//      Using a Stack to do it iterative way
    // if (t1 == null)
    //     return t2;
    // Stack < TreeNode[] > stack = new Stack < > ();
    // stack.push(new TreeNode[] {t1, t2});
    // while (!stack.isEmpty()) {
    //     TreeNode[] t = stack.pop();
    //     if (t[0] == null || t[1] == null) {
    //         continue;
    //     }
    //     t[0].val += t[1].val;
    //     if (t[0].left == null) {
    //         t[0].left = t[1].left;
    //     } else {
    //         stack.push(new TreeNode[] {t[0].left, t[1].left});
    //     }
    //     if (t[0].right == null) {
    //         t[0].right = t[1].right;
    //     } else {
    //         stack.push(new TreeNode[] {t[0].right, t[1].right});
    //     }
    // }
    // return t1;

    }
}

