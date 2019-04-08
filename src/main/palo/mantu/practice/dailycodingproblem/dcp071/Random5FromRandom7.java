package palo.mantu.practice.dailycodingproblem.dcp071;

import java.security.SecureRandom;

/*
Daily Coding Problem: Problem #71

This problem was asked by Two Sigma.

Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability,
implement a function rand5() that returns an integer from 1 to 5 (inclusive).
*/
public class Random5FromRandom7 {
    public int rand5() {
        Random7 o = new Random7(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        int rand = o.rand7();
        while (rand == 6 || rand == 7) {
            rand = o.rand7();
        }
        return rand;
    }

    class Random7 {
        private int[] stream;

        Random7(int[] stream) {
            this.stream = stream;
        }

        int rand7() {
            return stream[new SecureRandom().nextInt(6)];
        }
    }
}