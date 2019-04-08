package palo.mantu.practice.dailycodingproblem.dcp062;

/*
This problem was asked by Facebook.

There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner
and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
*/
public class MatrixTopLeftToBottomRight {
    public int count(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}