package palo.mantu.practice.dailycodingproblem.dcp005;

/*
Daily Coding Problem: Problem #5

This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.

For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
Given this implementation of cons:
    def cons(a, b):
        def pair(f):
            return f(a, b)
        return pair
Implement car and cdr.
*/
public class Cons {
    private int head;
    private int tail;

    public Cons(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int[] pair() {
        return new int[] { head, tail };
    }

    public int car() {
        return head;
    }

    public int cdr() {
        return tail;
    }
}