package palo.mantu.practice.dailycodingproblem.dcp001;

import java.util.HashMap;
import java.util.Map;

/*
Daily Coding Problem: Problem #1
 
This problem was recently asked by Google.
  
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
  
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
  
Bonus: Can you do this in one pass?
*/
public class IntegerPairAsSum {
    public int[] search(int[] input, int sum) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; input != null && i < input.length; i++) {
            if (complements.containsKey(input[i])) {
                return new int[] { complements.get(input[i]), i };
            }
            complements.put(sum - input[i], i);
        }
        return null;
    }

    public int[] searchSorted(int[] input, int sum) {
        int low = 0;
        int high = input.length - 1;
        while (low < high) {
            int loopSum = input[low] + input[high];
            if (sum == loopSum) {
                return new int[] { low, high };
            }
            if (sum > loopSum) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

    public int[] searchSortedRecursive(int[] input, int sum, int low, int high) {
        while (low < high) {
            int loopSum = input[low] + input[high];
            if (sum == loopSum) {
                return new int[] { low, high };
            }
            if (sum > loopSum) {
                return searchSortedRecursive(input, sum, ++low, high);
            }
            return searchSortedRecursive(input, sum, low, --high);
        }
        return null;
    }
}