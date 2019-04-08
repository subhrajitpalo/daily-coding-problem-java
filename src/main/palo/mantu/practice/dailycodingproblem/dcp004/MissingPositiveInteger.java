package palo.mantu.practice.dailycodingproblem.dcp004;

import static java.util.Arrays.sort;

/*
Daily Coding Problem: Problem #4
 
This problem was asked by Stripe.
  
Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3. You can modify the input array in-place.
*/
public class MissingPositiveInteger {
    public int search(int[] input) {
        sort(input);
        int prev = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 1) {
                continue;
            }
            if (input[i] - prev != 1) {
                return prev + 1;
            }
            prev = input[i];
        }
        return prev + 1;
    }
}