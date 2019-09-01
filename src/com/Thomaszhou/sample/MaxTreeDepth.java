package com.Thomaszhou.sample;

public class MaxTreeDepth {
//    Given a binary tree, find its maximum depth.
//
//    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//    Note: A leaf is a node with no children.
//
//    Example:
//
//    Given binary tree [3,9,20,null,null,15,7],
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//            return its depth = 3.
    //Definition for a binary tree node.
//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//     }
//}

    public static int maxDepth(TreeNode root) {
        //Simply swap left and right, do the same recursively for the left and right respectively
        if (!(root instanceof TreeNode)){
            return 0;
        }
        if(!(root.left instanceof TreeNode) && !(root.right instanceof TreeNode)){
            return 1;
        }
        else{
            return  1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        //New way if we could have two parameter.
//        public int maxDepth(TreeNode root,int depth){
//            if(root == null) return depth;
//            return Math.max(maxDepth(root.left, depth+1), maxDepth(root.right, depth+1))
//        }
    }

}

