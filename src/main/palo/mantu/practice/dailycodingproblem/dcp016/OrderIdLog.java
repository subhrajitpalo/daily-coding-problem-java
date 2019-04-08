package palo.mantu.practice.dailycodingproblem.dcp016;

import java.util.HashMap;
import java.util.Map;

/*
Daily Coding Problem: Problem #16

This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log.
Implement a data structure to accomplish this, with the following API:
    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.
*/
public class OrderIdLog {
    private Map<Integer, Integer> orderIds = new HashMap<>();

    public synchronized void record(int orderId) {
        orderIds.put(orderIds.size(), orderId);
    }

    public int getRecordId(int index) {
        return orderIds.get(index);
    }
}