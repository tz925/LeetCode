package com.Thomaszhou.sample.TreesAndGraphs;

import com.Thomaszhou.sample.LinkedLIst.ListNode;

import java.util.ArrayDeque;

/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.
 */
public class InorderSuccessorBST {
    /*
    solution 1: inorder DFS traversal output to a list, then BinarySearch the index in list, return list[index+1]
     time O(n) = traversal(n) + BinarySearch(logn); space O(n) = call Stack(n) + extra list(n)
     */

    /*
    solution 2: inorder DFS use flag and ans to know if we have found p and keep p's next node's value.
    time O(n) space O(n) recursive
     */
    private boolean foundP = false;
    private TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helperInorderDFS(root, p);
        return ans;
    }

    private void helperInorderDFS(TreeNode root, TreeNode p){
        if (root == null) return;

        helperInorderDFS(root.left, p);
        if (root == p){
            foundP = true;
        }
        else if(foundP && ans == null){
            ans = root;
        }else if(foundP && ans != null){
            //we got the result abort rest of code
            return;
        }
        helperInorderDFS(root.right, p);
    }

    /*
    solution 3
     */
    public  TreeNode inorderSuccessor3(TreeNode root, TreeNode p){
        // the successor is somewhere lower in the right subtree
        // successor: one step right and then left till you can
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        // the successor is somewhere upper in the tree
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inorder = Integer.MIN_VALUE;

        // inorder traversal : left -> node -> right
        while (!stack.isEmpty() || root != null) {
            // 1. go left till you can
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 2. all logic around the node
            root = stack.pop();
            // if the previous node was equal to p
            // then the current node is its successor
            if (inorder == p.val) return root;
            inorder = root.val;

            // 3. go one step right
            root = root.right;
        }

        // there is no successor
        return null;
    }

    /*
    solution 4, use property of BST check val of cur, if bigger than p, cur is candidate, go left.
    if smaller than p, go right.
     */

    public TreeNode inorderSuccessor4(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode cur = root;
        TreeNode candidate = null;
        while(cur !=null){
            if (cur.val > p.val){
                candidate = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return candidate;
    }
}
