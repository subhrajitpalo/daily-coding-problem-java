package palo.mantu.practice.algorithm;

public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int beg, int end) {
        if (beg < end) {
            int part = partition(arr, beg, end);
            sort(arr, beg, part - 1);
            sort(arr, part + 1, end);
        }
    }

    private int partition(int[] arr, int beg, int end) {
        int pivot = arr[end];
        int i = (beg - 1);
        for (int j = beg; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
}