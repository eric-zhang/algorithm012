package com.leetcode.week07;

import java.util.Objects;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-08-23-23-11:12 PM
 */
public class Trie {

    TrieNode root ;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i = 0; i < len; i++) {
            char curr = word.charAt(i);
            if(!node.containKey(curr)){
                node.put(curr,new TrieNode());
            }
            node = node.get(curr);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return Objects.nonNull(node) && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i = 0; i < len ;i++) {
            char curr = word.charAt(i);
            if(node.containKey(curr)){
                node = node.get(curr);
            }else {
                return null;
            }
        }
        return node;
    }


    public static class TrieNode {

        private TrieNode[] links = new TrieNode[26];

        private boolean isEnd;

        public boolean containKey(char ch) {
            return Objects.nonNull(links[ch - 'a']);
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch,TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    public static void main(String[] args) {
        String word = "apple";
        String word2 = "applecc";
        String search = "app";
        Trie trie = new Trie();
        trie.insert(word);
        trie.insert(word2);
        System.out.println(trie.search(search));
        System.out.println(trie.startsWith(search));
        System.out.println(trie.startsWith(word));
    }
}
