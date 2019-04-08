package palo.mantu.practice.dailycodingproblem.dcp007;

import static java.lang.Integer.parseInt;

/*
Daily Coding Problem: Problem #7

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/
public class MessageDecoder {
    public int count(String input, int len, Integer[] memo) {
        if (input == null) {
            return 0;
        }
        if (len == 0) {
            return 1;
        }
        int len1 = input.length() - len;
        if (input.charAt(len1) == '0') {
            return 0;
        }
        if (memo[len - 1] != null) {
            return memo[len - 1];
        }
        int result = count(input, len - 1, memo);
        if (len >= 2 && parseInt(input.substring(len1, len1 + 2)) <= 26) {
            result += count(input, len - 2, memo);
        }
        memo[len - 1] = result;
        return result;
    }
}