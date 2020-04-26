package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.*;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    private int L;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        L = beginWord.length();

        //build a map for intermediate to complete word e.g. 'g*t' -> 'got' 'get'
        Map<String, List<String>> comboDict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String junction = word.substring(0,i) + '*' + word.substring(i+1,L);
                List<String> possibleWords = comboDict.getOrDefault(junction, new ArrayList<>());
                possibleWords.add(word);
                comboDict.put(junction, possibleWords);
            }
        });

        Queue<String> beginQ = new LinkedList<>();
        beginQ.offer(beginWord);
        Queue<String> endQ = new LinkedList<>();
        endQ.offer(endWord);
        Map<String, Integer> visitedBegin = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedEnd.put(endWord, 1);

        while(!beginQ.isEmpty() && !endQ.isEmpty()){
            int result = oneStep(comboDict, beginQ, visitedBegin, visitedEnd);
            if(result > 0) return result;

            result = oneStep(comboDict, endQ, visitedEnd, visitedBegin);
            if(result > 0) return result;
        }


        return 0;
    }

    private int oneStep(Map<String, List<String>> comboDict, Queue<String> Q, Map<String, Integer> fromVisited, Map<String, Integer> toVisited){
        String word = Q.poll();
        int level = fromVisited.get(word);
        for (int i = 0; i < L; i++) {
            String junction = word.substring(0,i) + '*' + word.substring(i+1,L);
            for (String next: comboDict.getOrDefault(junction, new ArrayList<>())){
                if (toVisited.keySet().contains(next)){
                    return toVisited.get(next) + level;
                }

                if (!fromVisited.keySet().contains(next)){
                    fromVisited.put(next, level+1);
                    Q.offer(next);
                }
            }

        }

        return -1;
    }
}
