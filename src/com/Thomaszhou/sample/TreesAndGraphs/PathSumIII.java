package com.Thomaszhou.sample.TreesAndGraphs;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */

import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

import java.util.HashMap;

public class PathSumIII {
//    public int pathSum(TreeNode root, int sum){
//        // brute force use DFS to traverse all nodes, for each node perform dfs-based test calculate paths start from this node
//        // note when find one node we should not stop by return, becuase there might be a path further down sum to sum.
//        // time is nlogn to n^2 (balanced tree to no-branching tree(linked list basically)) space is n to logn (no brnching to balanced tree)
//        if(root == null) return 0;
//        int cur = test(root, sum);
//        int left = pathSum(root.left, sum);
//        int right = pathSum(root.right, sum);
//
//        return cur + left + right;
//    }
//
//    private int test(TreeNode root, int sum){
//        if(root == null) return 0;
//        int found = 0;
//        if(root.val == sum) found = 1;
//        int left = test(root.left, sum - root.val);
//        int right = test(root.right, sum - root.val);
//
//        return found+left+right;
//    }
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
