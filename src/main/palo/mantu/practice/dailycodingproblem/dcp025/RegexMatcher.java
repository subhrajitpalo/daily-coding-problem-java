package palo.mantu.practice.dailycodingproblem.dcp025;

import java.util.ArrayList;
import java.util.List;

/*
Daily Coding Problem: Problem #25

This problem was asked by Facebook.

Implement regular expression matching with the following special characters:
    . (period) which matches any single character
    * (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression
and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true.
The same regular expression on the string "raymond" should return false.
Given the regular expression ".*at" and the string "chat", your function should return true.
The same regular expression on the string "chats" should return false.
*/
public class RegexMatcher {
    public boolean match(String text, String pattern) {
        if (null != text && null != pattern) {
            List<String> subPatterns = getSubPatterns(pattern);
            int patternIndex = 0;
            boolean fastForward = false;
            for (int i = 0; i < text.length(); i++) {
                if (patternIndex == subPatterns.size()) {
                    return false;
                }
                String subPattern = subPatterns.get(patternIndex);
                if (!fastForward && ".".equals(subPattern)) {
                    patternIndex++;
                    continue;
                } else if (!fastForward && "*".equals(subPattern)) {
                    fastForward = true;
                    patternIndex++;
                    subPattern = subPatterns.get(patternIndex);
                }
                if (text.substring(i).length() < subPattern.length()) {
                    break;
                }
                String temp = text.substring(i, i + subPattern.length());
                if (subPattern.equals(temp)) {
                    i = i + subPattern.length() - 1;
                    patternIndex++;
                    fastForward = false;
                } else {
                    if (!fastForward) {
                        break;
                    }
                }
            }
            if (patternIndex == subPatterns.size()) {
                return true;
            }
        }
        return false;
    }

    private List<String> getSubPatterns(String pattern) {
        List<String> subPatterns = new ArrayList<>();
        int beginIndex = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '.' || pattern.charAt(i) == '*') {
                if (i != beginIndex) {
                    subPatterns.add(pattern.substring(beginIndex, i));
                }
                subPatterns.add(Character.toString(pattern.charAt(i)));
                beginIndex = i + 1;
            }
        }
        if (beginIndex < pattern.length() - 1) {
            subPatterns.add(pattern.substring(beginIndex, pattern.length()));
        }
        return subPatterns;
    }
}