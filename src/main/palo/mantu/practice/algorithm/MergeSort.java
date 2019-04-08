package palo.mantu.practice.algorithm;

public class MergeSort {
    public void sort(int[] arr) {
        sort(arr, arr.length);
    }

    private void sort(int[] arr, int len) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        int[] right = new int[len - mid];
        for (int i = mid; i < len; i++) {
            right[i - mid] = arr[i];
        }
        sort(left, mid);
        sort(right, len - mid);

        merge(arr, left, right, mid, len - mid);
    }

    private void merge(int[] arr, int[] left, int[] right, int beg, int end) {
        int i = 0, j = 0, k = 0;
        while (i < beg && j < end) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < beg) {
            arr[k++] = left[i++];
        }
        while (j < end) {
            arr[k++] = right[j++];
        }
    }
}