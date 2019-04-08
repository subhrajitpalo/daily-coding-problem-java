package palo.mantu.practice.algorithm;

public class Factorial {
    public int nonRecursive(int input) {
        if (input <= 0) {
            return 1;
        }
        int output = 1;
        for (int i = input; i > 0; i--) {
            output = output * i;
        }
        return output;
    }

    public int recursive(int input) {
        if (input <= 0) {
            return 1;
        }
        return input * recursive(input - 1);
    }
}