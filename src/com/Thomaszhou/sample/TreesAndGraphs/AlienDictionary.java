package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.*;

/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    /*
    topological sort
     */
    public String alienOrder(String[] words) {
        //build realationship map and inDegree map
        int[] inDegree = new int[256];
        Map<Character, List<Character>> adjMap = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c] = 0;
                adjMap.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.startsWith(s2) && s1.length() > s2.length()) return "";

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2){
                    List<Character> temp = adjMap.getOrDefault(c1, new ArrayList<>());
                    temp.add(c2);
                    adjMap.put(c1, temp);

                    inDegree[c2] += 1;

                    break;
                }
            }
        }

        // find starting points where inDegree  == 0
        Queue<Character> queue = new LinkedList<>();

        for (char c: adjMap.keySet()) {
            if (inDegree[c] == 0){
                queue.offer(c);
            }
        }

        // start topological sort
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for (char next: adjMap.get(c)) {
                inDegree[next] -= 1;
                if (inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        // if there is cycle, then some char will not be removed from graph. hence sb.length will be smaller than total C count.
        if (sb.length() < adjMap.size()) {
            return "";
        }

        return sb.toString();
    }

    /*
    DFS with node coloring for detecting cycle.
     */
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();

    public String alienOrder2(String[] words) {

        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }


        if (output.length() < reverseAdjList.size()) {
            return "";
        }
        return output.toString();
    }

    // Return true iff no cycles detected.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}
