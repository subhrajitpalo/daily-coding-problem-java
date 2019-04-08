package palo.mantu.practice.dailycodingproblem.dcp012;

/*
Daily Coding Problem: Problem #12

This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:
1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time,
you could climb any number from a set of positive integers X?
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/
public class StaircaseClimbSteps {
    public int count(int stairCount, int[] steps) {
        if (stairCount == 0 || stairCount == 1) {
            return 1;
        }
        int[] ways = new int[stairCount + 1];
        ways[0] = 1;
        for (int i = 1; i <= stairCount; i++) {
            int total = 0;
            for (int step : steps) {
                if (i - step >= 0) {
                    total = total + count(i - step);
                }
            }
            ways[i] = total;
        }
        return ways[stairCount];
    }

    public int count(int stairCount) {
        int a = 1, b = 1, c;
        for (int i = 2; i <= stairCount; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}