package palo.mantu.practice.dailycodingproblem.dcp073;

import palo.mantu.practice.datastructure.SinglyLinkedList;

/*
Daily Coding Problem: Problem #73

This problem was asked by Google.

Given the head of a singly linked list, reverse it in-place.
*/
public class ReverseSinglyLinkedList {
    public SinglyLinkedList reverse(SinglyLinkedList node) {
        SinglyLinkedList prev = null, cur = node, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node = prev;
        return node;
    }
}