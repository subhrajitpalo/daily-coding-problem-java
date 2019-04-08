package palo.mantu.practice.algorithm;

public class Fibonacci {
    public int nonRecursive(int input) {
        if (input == 0) {
            return 0;
        }
        int a = 0, b = 1, c;
        for (int i = 2; i <= input; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public int recursive(int input) {
        if (input <= 1) {
            return input;
        }
        return recursive(input - 1) + recursive(input - 2);
    }
}