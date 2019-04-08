package palo.mantu.practice.dailycodingproblem.dcp006TODO;

/*
Daily Coding Problem: Problem #6

This problem was asked by Google.

An XOR linked list is a more memory efficient doubly linked list.
Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node.
Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
If using a language that has no pointers (such as Python),
you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.
*/
public class XorLinkedList {
    private int value;
    private XorLinkedList both;

    private int getPointer(XorLinkedList node) {
        // return address
        return 0;
    }

    private XorLinkedList dereferencePointer(int address) {
        // return node
        return new XorLinkedList();
    }

    public void add(XorLinkedList node) {
    }

    public XorLinkedList get(int index) {
        return null;
    }
}