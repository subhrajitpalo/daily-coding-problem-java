package palo.mantu.practice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import static java.util.Arrays.asList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import palo.mantu.practice.algorithm.ArrayAddOne;
import palo.mantu.practice.algorithm.ArraySubsetAsSum;
import palo.mantu.practice.algorithm.BinarySearch;
import palo.mantu.practice.algorithm.Factorial;
import palo.mantu.practice.algorithm.Fibonacci;
import palo.mantu.practice.algorithm.FileCount;
import palo.mantu.practice.algorithm.HighestProduct;
import palo.mantu.practice.algorithm.InsertionSort;
import palo.mantu.practice.algorithm.MergeSort;
import palo.mantu.practice.algorithm.QuickSort;
import palo.mantu.practice.algorithm.ReservoirSampling;
import palo.mantu.practice.algorithm.FileCount.Directory;

public class AlgorithmsTest {
    @Test
    @DisplayName("Add one to integer array")
    public void addOneToIntegerArray() {
        ArrayAddOne o = new ArrayAddOne();

        assertArrayEquals(new int[] { 1, 0, 0, 0 }, o.add(new int[] { 9, 9, 9 }));
        assertArrayEquals(new int[] { 1, 2, 4 }, o.add(new int[] { 1, 2, 3 }));
        assertArrayEquals(new int[] { 2, 0, 0 }, o.add(new int[] { 1, 9, 9 }));
    }

    @Test
    @DisplayName("Array subset as sum count")
    public void countArraySubsetAsSum() {
        ArraySubsetAsSum o = new ArraySubsetAsSum();

        assertEquals(2, o.count(new int[] { 2, 4, 6, 10 }, 16, 3, new HashMap<>()));
    }

    @Test
    @DisplayName("Binary search")
    public void binarySeach() {
        BinarySearch o = new BinarySearch();

        assertEquals(1, o.search(new int[] { 1, 3, 4, 7, 9 }, 3));
        assertEquals(3, o.search(new int[] { 1, 2, 4, 5, 9 }, 5));
        assertEquals(-1, o.search(new int[] { 0, 1, 4, 7, 8 }, 6));

        assertEquals(1, o.searchRecursive(new int[] { 1, 3, 4, 7, 9 }, 3, 0, 4));
        assertEquals(3, o.searchRecursive(new int[] { 1, 2, 4, 5, 9 }, 5, 0, 4));
        assertEquals(-1, o.searchRecursive(new int[] { 0, 1, 4, 7, 8 }, 6, 0, 4));
    }

    @Test
    @DisplayName("Factorial")
    public void factorial() {
        Factorial o = new Factorial();

        assertEquals(1, o.nonRecursive(0));
        assertEquals(1, o.nonRecursive(1));
        assertEquals(120, o.nonRecursive(5));

        assertEquals(1, o.recursive(0));
        assertEquals(1, o.recursive(1));
        assertEquals(120, o.recursive(5));
    }

    @Test
    @DisplayName("Fibonacci")
    public void fibonacci() {
        Fibonacci o = new Fibonacci();

        assertEquals(0, o.nonRecursive(0));
        assertEquals(1, o.nonRecursive(1));
        assertEquals(1, o.nonRecursive(2));
        assertEquals(2, o.nonRecursive(3));
        assertEquals(3, o.nonRecursive(4));

        assertEquals(0, o.recursive(0));
        assertEquals(1, o.recursive(1));
        assertEquals(1, o.recursive(2));
        assertEquals(2, o.recursive(3));
        assertEquals(3, o.recursive(4));
    }

    @Test
    @DisplayName("File count")
    public void countFiles() {
        FileCount o = new FileCount();

        Directory root = o.new Directory(asList("7.txt", "8.txt"));
        Directory doc = o.new Directory("4.pdf");
        doc.addSub(o.new Directory(asList("1.js", "2.js", ".gitignore")));
        doc.addSub(o.new Directory("3.html"));
        root.addSub(doc);
        root.addSub(o.new Directory("5.mp3"));
        root.addSub(o.new Directory("6.jpg"));
        assertEquals(9, o.countFiles(root));
        assertEquals(1, o.countHiddenFiles(root));
    }

    @Test
    @DisplayName("Highest product of numbers with sum as given number")
    public void searchLargestProduct() {
        HighestProduct o = new HighestProduct();

        assertEquals(12, o.search(7));
        assertEquals(18, o.search(8));
        assertEquals(27, o.search(9));
        assertEquals(36, o.search(10));
        assertEquals(54, o.search(11));
    }

    @Test
    @DisplayName("Insertion sort")
    public void insertionSort() {
        InsertionSort o = new InsertionSort();

        int[] arr = new int[] { 5, 3, 1, 2, 4, 1 };
        o.sort(arr);
        assertArrayEquals(new int[] { 1, 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    @DisplayName("Merge sort")
    public void mergeSort() {
        MergeSort o = new MergeSort();

        int[] arr = new int[] { 5, 3, 1, 2, 4, 1 };
        o.sort(arr);
        assertArrayEquals(new int[] { 1, 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    @DisplayName("Quick sort")
    public void quickSort() {
        QuickSort o = new QuickSort();

        int[] arr = new int[] { 5, 3, 1, 2, 4, 1 };
        o.sort(arr);
        assertArrayEquals(new int[] { 1, 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    @DisplayName("Reservoir sampling - Random elements from a stream")
    public void reservoirSampling() {
        ReservoirSampling o = new ReservoirSampling();

        assertEquals(3, o.selectKItems(new int[] { 1, 2, 3, 4, 5 }, 3).length);
    }
}