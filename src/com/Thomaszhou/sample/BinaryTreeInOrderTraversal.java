package com.Thomaszhou.sample;

import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    //Recursive Time(n) because we visit n nodes, Space(logn) on average (n) on worst case.
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        helper(root, result);
//        return result;
//    }
//
//    private void helper(TreeNode root, List<Integer> result){
//        if (root != null){
//            helper(root.left, result);
//            result.add(root.val);
//            helper(root.right, result);
//        }
//    }

    // Iterative time(n) space(n)
    public List < Integer > inorderTraversal(TreeNode root) {
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

}
