package com.Thomaszhou.sample.TreesAndGraphs;

import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

public class ConvertBSTToGreaterTree {
    /*Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed
    to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

     */

    public static TreeNode convertBST (TreeNode root){
        //If we do for each node traverse whole tree to find greater values then it will be n^2 Time.
        //Or, we can put all values in an array (additional space) then traverse the BST again to update values.
        // when updating we need to find all value bigger than current.value the time varies depends on data structure
        //that we store the values in. for regular array will be n*n. Overall n+n^2 -> n^2
        // will be time O(n), extra array of n values space O(n).

        // presumably BST has sorted property, therefore, greater values are node's right subtree total + parent + parent's right subtree(if it
        // is left child of parent). Then we should only need to traverse the tree once O(n) recursively

        if (root == null) {
            return null;
        }
        convertBSTHelper(root, 0, 0);
        return root;

    }
    private static int convertBSTHelper(TreeNode root,  int parentVal, int parentRightTotal){
        // parentVal here Actually is total result from parent/grandparent branch same for parentRightTotal
        // together these two values represent every value that is above and to the right of parent node.
        int rightTotal = (root.right == null)? 0 : convertBSTHelper(root.right, parentVal , parentRightTotal);
        int leftTotal = (root.left == null)? 0 : convertBSTHelper(root.left, root.val+parentVal, rightTotal+parentRightTotal);
        //if is RIGHT, the following still work.
        int valueBefore = root.val;
        root.val += parentVal + parentRightTotal + rightTotal;
        return valueBefore+rightTotal+leftTotal;
    }
}
