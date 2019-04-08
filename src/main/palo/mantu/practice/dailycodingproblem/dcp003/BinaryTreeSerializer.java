package palo.mantu.practice.dailycodingproblem.dcp003;

import java.util.Scanner;

import palo.mantu.practice.datastructure.BinaryTree;

/*
Daily Coding Problem: Problem #3
 
This problem was asked by Google.
  
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
and deserialize(s), which deserializes the string back into the tree.
  
For example, given the following Node class
    class Node:
        def __init__(self, val, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right
The following test should pass:
    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert deserialize(serialize(node)).left.left.val == 'left.left'
*/
public class BinaryTreeSerializer {
    private static final String MARKER = "#";
    private static final String SPACE = " ";

    public String serialize(BinaryTree bt) {
        StringBuffer str = new StringBuffer(bt.text + SPACE);
        if (bt.left == null) {
            str.append(MARKER).append(SPACE);
        } else {
            str.append(serialize(bt.left));
        }
        if (bt.right == null) {
            str.append(MARKER).append(SPACE);
        } else {
            str.append(serialize(bt.right));
        }
        return str.toString();
    }

    public BinaryTree deserialize(String bt) {
        return deserialize(new Scanner(bt));
    }

    private BinaryTree deserialize(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        }
        String currentWord = sc.next();
        if (currentWord.equals(MARKER)) {
            return null;
        }
        return new BinaryTree(currentWord, deserialize(sc), deserialize(sc));
    }
}