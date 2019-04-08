package palo.mantu.practice.dailycodingproblem.dcp008;

import palo.mantu.practice.datastructure.BinaryTree;

/*
Daily Coding Problem: Problem #8

This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
*/
public class UnivalSubtree {
    public int[] count(BinaryTree root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] leftUnival = count(root.left);
        int[] rightUnival = count(root.right);
        boolean isUnival = true;
        if (leftUnival[1] == 1 || rightUnival[1] == 1) {
            isUnival = false;
        }
        if (root.left != null && root.value != root.left.value) {
            isUnival = false;
        }
        if (root.right != null && root.value != root.right.value) {
            isUnival = false;
        }
        if (isUnival) {
            return new int[] { leftUnival[0] + rightUnival[0] + 1, 0 };
        }
        return new int[] { leftUnival[0] + rightUnival[0], 1 };
    }
}