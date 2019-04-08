package palo.mantu.practice.dailycodingproblem.dcp085;

/*
Daily Coding Problem: Problem #85

This problem was asked by Facebook.

Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations.
You can assume b can only be 1 or 0.
*/
public class IntegerBitwiseOperation {
    public int intbit(int x, int y, int z) {
        z = -z;
        return (x & z) | (y & ~z);
    }
}