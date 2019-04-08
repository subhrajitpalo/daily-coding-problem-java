package palo.mantu.practice.algorithm;

import java.util.Map;

public class ArraySubsetAsSum {
    public int count(int[] input, int sum, int i, Map<String, Integer> memo) {
        String key = Integer.toString(sum) + ":" + Integer.toString(i);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (sum == 0) {
            return 1;
        } else if (sum < 0) {
            return 0;
        } else if (i < 0) {
            return 0;
        } else if (sum < input[i]) {
            memo.put(key, count(input, sum, i - 1, memo));
        } else {
            memo.put(key, count(input, sum - input[i], i - 1, memo) + count(input, sum, i - 1, memo));
        }
        return memo.get(key);
    }
}