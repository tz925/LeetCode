package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigZagTraverse {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //iterative
//        boolean reverse = false;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            List<Integer> tempList = new LinkedList<>();
//            int curLevelSize = queue.size();
//
//            for (int i = 0; i < curLevelSize; i++) {
//                TreeNode cur = queue.poll();
//                if (reverse) tempList.add(0, cur.val);
//                else tempList.add(cur.val);
//                if (cur.left != null) queue.add(cur.left);
//                if (cur.right != null) queue.add(cur.right);
//            }
//            result.add(tempList);
//            reverse = !reverse;
//        }

        //Recursive
        zigzag(root, result, 0);

        return result;
    }

    private void zigzag(TreeNode root, List<List<Integer>> result, int level){
        if (root == null) return;

        if (result.size() <= level){
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }

        List<Integer> curLevel = result.get(level);

        if (level % 2 == 0) curLevel.add(root.val);
        else curLevel.add(0,root.val);

        zigzag(root.left, result, level+1);
        zigzag(root.right, result, level+1);
    }
}
