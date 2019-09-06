package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class SymmtricTree {
    // Symmtric DFS to check if left and right are same. Time(n) Space(n) Recursive
//    List<Integer> left = new ArrayList<>();
//    List<Integer> right = new ArrayList<>();
//
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        if (root.left != null) leftDFS(root.left);
//        else left.add(null);
//        if (root.right != null) rightDFS(root.right);
//        else right.add(null);
//        for(int i=0; i<left.size();i++){
//            if(left.get(i)!=right.get(i)) return false;
//        }
//        return true;
//    }
//
//    private void leftDFS(TreeNode node){
//        left.add(node.val);
//        if (node.left != null) leftDFS(node.left);
//        else left.add(null);
//        if (node.right != null) leftDFS(node.right);
//        else left.add(null);
//    }
//
//    private void rightDFS(TreeNode node){
//        right.add(node.val);
//        if (node.right != null) rightDFS(node.right);
//        else right.add(null);
//        if (node.left != null) rightDFS(node.left);
//        else right.add(null);
//    }

    /*
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
     */

    /*
    public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
     */
}

