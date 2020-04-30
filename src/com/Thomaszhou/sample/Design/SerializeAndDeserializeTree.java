package com.Thomaszhou.sample.Design;

import com.Thomaszhou.sample.TreesAndGraphs.TreeNode;

import java.util.*;

public class SerializeAndDeserializeTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /*
    DFS pre-order
     */
    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    /*
    BFS
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) return "";
        String n = "null", sep = ",";
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int size = 0;
        TreeNode cur;
        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            size = dq.size();
            for (int i = 0; i < size; ++i) {
                cur = dq.poll();
                if (cur != null) {
                    sb.append(cur.val);
                    dq.offer(cur.left);
                    dq.offer(cur.right);
                } else {
                    sb.append(n);
                }
                sb.append(sep);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        if (vals == null || vals.length == 0) return null;

        String n = "null";
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        TreeNode cur, next;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int size = 0, index = 1;
        dq.offer(root);

        while (!dq.isEmpty()) {
            size = dq.size();
            for (int i = 0; i < size; ++i) {
                cur = dq.poll();

                for (int j = index; j < index + 2 && j < vals.length; ++j) {
                    if (vals[j].equals(n)) {
                        if (j % 2 == 1) {
                            cur.left = null;
                        } else {
                            cur.right = null;
                        }
                    } else {
                        next = new TreeNode(Integer.parseInt(vals[j]));
                        dq.offer(next);
                        if (j % 2 == 1) {
                            cur.left = next;
                        } else {
                            cur.right = next;
                        }
                    }
                }

                index += 2;
            }
        }

        return root;
    }
}
