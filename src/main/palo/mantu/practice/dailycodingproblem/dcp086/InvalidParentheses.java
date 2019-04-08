package palo.mantu.practice.dailycodingproblem.dcp086;

/*
Daily Coding Problem: Problem #86

This problem was asked by Google.

Given a string of parentheses,
write a function to compute the minimum number of parentheses to be removed to make the string valid
(i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1.
Given the string ")(", you should return 2, since we must remove all of them.
*/
public class InvalidParentheses {
    public int count(String input) {
        int count = 0;
        int openCount = 0;
        if (input != null) {
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    openCount++;
                } else if (c == ')') {
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        count++;
                    }
                }
            }
        }
        return count + openCount;
    }
}