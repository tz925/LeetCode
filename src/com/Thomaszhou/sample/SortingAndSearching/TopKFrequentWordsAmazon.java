package com.Thomaszhou.sample.SortingAndSearching;

import java.util.*;

/*
Amazon OA 2020
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWordsAmazon {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
        }
        //min heap
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.getOrDefault(w1, 0) == count.getOrDefault(w2, 0) ?
                        w2.compareTo(w1):
                        count.getOrDefault(w1, 0) - count.getOrDefault(w2, 0)
        );

        for (String word: count.keySet()){
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while(!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
