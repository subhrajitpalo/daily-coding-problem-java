package palo.mantu.practice.dailycodingproblem.dcp013;

import java.util.HashSet;
import java.util.Set;

/*
Daily Coding Problem: Problem #13

This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/
public class LongestSubstringMinChars {
    public int length(String s, int k) {
        int beg = 0;
        String cur = null;
        Set<Character> uChar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uChar.add(s.charAt(i));
            if (uChar.size() > k) {
                if (cur == null || s.substring(beg, i).length() > cur.length()) {
                    cur = s.substring(beg, i);
                }
                uChar.remove(s.charAt(beg));
                beg = getBeginIndex(s, i - 1, k - 1);
            }
        }
        if (cur != null && s.substring(beg).length() > cur.length()) {
            cur = s.substring(beg);
        }
        return cur == null ? 0 : cur.length();
    }

    private int getBeginIndex(String s, int e, int k) {
        Set<Character> uChar = new HashSet<>();
        for (int i = e; i >= 0; i--) {
            uChar.add(s.charAt(i));
            if (uChar.size() == k) {
                return i;
            }
        }
        return 0;
    }
}