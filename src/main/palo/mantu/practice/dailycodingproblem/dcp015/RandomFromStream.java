package palo.mantu.practice.dailycodingproblem.dcp015;

import java.security.SecureRandom;

/*
Daily Coding Problem: Problem #15

This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
*/
public class RandomFromStream {
    public int random(int[] stream, int i) {
        if (i == 0) {
            return stream[i];
        }
        return stream[new SecureRandom().nextInt(i)];
    }
}