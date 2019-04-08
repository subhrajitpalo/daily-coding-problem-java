package palo.mantu.practice.algorithm;

public class ArrayAddOne {
    public int[] add(int[] input) {
        int[] output = new int[input.length];
        boolean carryOver = true;
        for (int i = input.length - 1; i >= 0; i--) {
            output[i] = input[i];
            if (carryOver) {
                int plusOne = input[i] + 1;
                output[i] = plusOne;
                carryOver = false;
                if (plusOne == 10) {
                    output[i] = 0;
                    carryOver = true;
                }
            }
        }
        if (carryOver) {
            output = new int[input.length + 1];
            output[0] = 1;
        }
        return output;
    }
}