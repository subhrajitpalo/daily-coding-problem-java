package palo.mantu.practice.algorithm;

public class BinarySearch {
    public int search(int[] input, int find) {
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + (high - 1) / 2;
            if (find == input[mid]) {
                return mid;
            }
            if (find > input[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int searchRecursive(int[] input, int find, int low, int high) {
        if (low <= high) {
            int mid = low + (high - 1) / 2;
            if (find == input[mid]) {
                return mid;
            }
            if (find > input[mid]) {
                return searchRecursive(input, find, mid + 1, high);
            }
            return searchRecursive(input, find, low, mid - 1);
        }
        return -1;
    }
}