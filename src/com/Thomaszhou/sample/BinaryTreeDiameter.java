package com.Thomaszhou.sample;

public class BinaryTreeDiameter {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        diameter = Math.max(diameter, left+right);
        return Math.max(left,right)+1;
    }
}
