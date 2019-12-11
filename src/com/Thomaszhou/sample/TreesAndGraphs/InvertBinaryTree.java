package com.Thomaszhou.sample.TreesAndGraphs;

import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

public class InvertBinaryTree {
//    Invert a binary tree.
//
//    Example:
//
//    Input:
//
//            4
//            /   \
//            2     7
//            / \   / \
//            1   3 6   9
//    Output:
//
//            4
//            /   \
//            7     2
//            / \   / \
//            9   6 3   1
//    Trivia:
//    This problem was inspired by this original tweet by Max Howell:
//
//    Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

    /* I found this particularly funny
    * I dont get how I can easily implement this but a guy who could get Homebrew couldnt get this.*/

    public static TreeNode invertTree(TreeNode root) {
        if (!(root instanceof TreeNode)){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left instanceof TreeNode){invertTree(root.left);}
        if(root.right instanceof TreeNode){invertTree(root.right);}
        return root;
    }
}
