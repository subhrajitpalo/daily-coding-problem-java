package palo.mantu.practice.dailycodingproblem.dcp018;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Daily Coding Problem: Problem #18

This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)

Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results.
You can simply print them out as you compute them.
*/
public class MaximumValueSubarray {
    public List<Integer> search(int[] arr, int k) {
        List<Integer> ret = new ArrayList<>();
        Deque<Integer> deck = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; i++) {
            while (!deck.isEmpty() && arr[i] >= arr[deck.peekLast()]) {
                deck.removeLast();
            }
            deck.addLast(i);
        }
        for (; i < arr.length; ++i) {
            ret.add(arr[deck.peek()]);
            while (!deck.isEmpty() && deck.peek() <= i - k) {
                deck.removeFirst();
            }
            while (!deck.isEmpty() && arr[i] >= arr[deck.peekLast()]) {
                deck.removeLast();
            }
            deck.addLast(i);
        }
        ret.add(arr[deck.peek()]);
        return ret;
    }
}