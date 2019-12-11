package com.Thomaszhou.sample.TreesAndGraphs;


import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

import java.util.*;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorBinaryTree {
    // O(n) 6ms 76.51% O(n) 35.2mb 5.55%
    // Recursive
//    private TreeNode ans = null;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        findNode(root, p, q);
//        return this.ans;
//    }
//
//    private boolean findNode(TreeNode curNode, TreeNode p, TreeNode q){
//        if (curNode == null) return false;
//        int left = findNode(curNode.left, p, q) ? 1 : 0;
//        int right = findNode(curNode.right, p, q) ? 1 : 0;
//        int mid = (curNode == p || curNode == q) ? 1 : 0;
//
//        if (mid + left + right >= 2) this.ans = curNode;
//
//        return (mid + left + right > 0);
//    }

    // Iterative
    // O(n) 13ms 14.25% O(n) 35.3MB 5.55%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //stack for tree Traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        //Map for parent pointers
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        parentMap.put(root, null);
        stack.push(root);

        //iterate until we find both p and q
        while(!parentMap.containsKey(p) || !parentMap.containsKey(q)){
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }//now we have found both p and q, and we have the parent pointer to traverse back

        //set to store all ancestors of p.
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        while(!ancestors.contains(q)){
            q = parentMap.get(q);
        }

        return q;
    }


}
