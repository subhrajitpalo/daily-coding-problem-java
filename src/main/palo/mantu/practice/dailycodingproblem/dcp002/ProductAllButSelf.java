package palo.mantu.practice.dailycodingproblem.dcp002;

/*
Daily Coding Problem: Problem #2
 
This problem was asked by Uber.
  
Given an array of integers, return a new array such that each element at index i of the new array is
the product of all the numbers in the original array except the one at i.
  
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].
  
Follow-up: what if you can't use division?
*/
public class ProductAllButSelf {
    public int[] product(int[] input) {
        int[] output = new int[input.length];
        int p = 1;
        for (int i = 0; i < input.length; i++) {
            output[i] = p;
            p = p * input[i];
        }
        p = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            output[i] = output[i] * p;
            p = p * input[i];
        }
        return output;
    }
}