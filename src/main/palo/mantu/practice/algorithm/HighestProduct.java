package palo.mantu.practice.algorithm;

public class HighestProduct {
    public int search(int num) {
        int remainder = num % 3;
        if (remainder == 1) {
            return ((int) Math.pow(3, (num - 4) / 3)) * 4;
        } else if (remainder == 2) {
            return ((int) Math.pow(3, num / 3)) * 2;
        }
        return (int) Math.pow(3, num / 3);
    }
}