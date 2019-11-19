package com.Thomaszhou.sample;
/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    //Time O(m) m is the key length, space O(m) worst case, complete new word. no prefix exist.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar)) node.put(curChar, new TrieNode());
            node = node.get(curChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    // Time O(m), Space(1)
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (node.containsKey(curChar)) node = node.get(curChar);
            else {
                node = null;
                break;
            }
        }
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            if (node.containsKey(curChar)) node = node.get(curChar);
            else {
                node = null;
                break;
            }
        }
        return node != null;
    }
}