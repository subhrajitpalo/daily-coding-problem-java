package palo.mantu.practice.dailycodingproblem.dcp009;

/*
Daily Coding Problem: Problem #9

This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/
public class NonAdjacentIntegerSum {
    public int search(int[] input) {
        int incl = input[0], excl = 0, tempExcl;
        for (int i = 1; i < input.length; i++) {
            tempExcl = incl > excl ? incl : excl;
            incl = excl + input[i];
            excl = tempExcl;
        }
        return incl > excl ? incl : excl;
    }
}