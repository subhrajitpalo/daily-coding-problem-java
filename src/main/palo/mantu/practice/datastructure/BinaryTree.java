package palo.mantu.practice.datastructure;

public class BinaryTree {
    public int value;
    public String text;
    public BinaryTree left, right, parent;
    public boolean locked;
    public int lockedChildCount;

    public BinaryTree(int value) {
        this.value = value;
    }

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(String text) {
        this.text = text;
    }

    public BinaryTree(String text, BinaryTree left, BinaryTree right) {
        this.text = text;
        this.left = left;
        this.right = right;
    }

    public void insert(int value) {
        if (value <= this.value) {
            if (left == null) {
                left = new BinaryTree(value);
                return;
            }
            left.insert(value);
            return;
        }
        if (right == null) {
            right = new BinaryTree(value);
            return;
        }
        right.insert(value);
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        }
        if (value < this.value) {
            if (left == null) {
                return false;
            }
            return left.contains(value);
        }
        if (right == null) {
            return false;
        }
        return right.contains(value);
    }

    private int height(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    public void printLevelOrder() {
        for (int i = 1; i <= height(this); i++) {
            printLevelOrder(this, i);
            System.out.println();
        }
    }

    private void printLevelOrder(BinaryTree root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.value);
            System.out.print(" ");
            return;
        }
        printLevelOrder(root.left, level - 1);
        printLevelOrder(root.right, level - 1);
    }

    public void printPreOrder() {
        System.out.print(value);
        System.out.print(" ");
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(value);
        System.out.print(" ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
        System.out.print(value);
        System.out.print(" ");
    }
}