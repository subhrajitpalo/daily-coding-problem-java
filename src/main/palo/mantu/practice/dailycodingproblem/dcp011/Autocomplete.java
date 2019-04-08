package palo.mantu.practice.dailycodingproblem.dcp011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Daily Coding Problem: Problem #11

This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/
public class Autocomplete {
    public List<String> search(List<String> dictionary, String prefix) {
        List<String> results = new ArrayList<String>();
        Trie node = new Trie(dictionary);
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return results;
            }
            node = node.children.get(c);
        }
        searchChildren(node, results);
        return results;
    }

    private void searchChildren(Trie node, List<String> results) {
        if (node.isWord) {
            results.add(node.prefix);
        }
        for (char c : node.children.keySet()) {
            searchChildren(node.children.get(c), results);
        }
    }

    class Trie {
        String prefix;
        Map<Character, Trie> children = new HashMap<Character, Trie>();
        boolean isWord;

        Trie(List<String> dictionary) {
            dictionary.forEach(s -> insertWord(s));
        }

        Trie(String prefix) {
            this.prefix = prefix;
        }

        void insertWord(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                if (!node.children.containsKey(prefix.charAt(i))) {
                    node.children.put(prefix.charAt(i), new Trie(prefix.substring(0, i + 1)));
                }
                node = node.children.get(prefix.charAt(i));
                if (i == prefix.length() - 1) {
                    node.isWord = true;
                }
            }
        }
    }
}