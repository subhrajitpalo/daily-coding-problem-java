package palo.mantu.practice.dailycodingproblem.dcp022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Daily Coding Problem: Problem #22

This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
you should return ['the', 'quick', 'brown', 'fox'].
Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
*/
public class SentenceFromWords {
    public List<String> search(String text, List<String> words) {
        if (text != null && words != null) {
            Set<String> dictionary = new HashSet<>();
            for (String word : words) {
                dictionary.add(word);
            }
            List<String> output = new ArrayList<>();
            int beg = 0;
            for (int i = 1; i < text.length(); i++) {
                if (dictionary.contains(text.substring(beg, i))) {
                    output.add(text.substring(beg, i));
                    beg = i;
                }
            }
            if (dictionary.contains(text.substring(beg))) {
                output.add(text.substring(beg));
            }
            return output;
        }
        return null;
    }
}