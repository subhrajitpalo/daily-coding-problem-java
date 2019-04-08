package palo.mantu.practice.dailycodingproblem.dcp019;

import static java.lang.Math.min;

/*
Daily Coding Problem: Problem #19

This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of K different colors.
He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
return the minimum cost which achieves this goal.
*/
public class PaintHouseMinimumCost {
    public int minCostKColor(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int prevMin = 0, prevMinOther = 0, prevColor = -1;
        for (int i = 0; i < costs.length; i++) {
            int curMin = Integer.MAX_VALUE;
            int curMinOther = Integer.MAX_VALUE;
            int curColor = -1;
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] = costs[i][j] + (prevColor == j ? prevMinOther : prevMin);

                if (costs[i][j] < curMin) {
                    curMinOther = curMin;
                    curMin = costs[i][j];
                    curColor = j;
                } else if (costs[i][j] < curMinOther) {
                    curMinOther = costs[i][j];
                }
            }
            prevMin = curMin;
            prevMinOther = curMinOther;
            prevColor = curColor;
        }
        return prevMin;
    }

    public int minCost3Color(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1]);
        }
        int n = costs.length - 1;
        return min(min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}