package palo.mantu.practice.datastructure;

public class SinglyLinkedList {
    public int value, length;
    public SinglyLinkedList next;

    public SinglyLinkedList(int value) {
        this.value = value;
        length++;
    }

    public SinglyLinkedList add(int value, int position) {
        SinglyLinkedList newNode = new SinglyLinkedList(value);
        if (position == 0) {
            newNode.next = this;
            newNode.length = this.length + 1;
            return newNode;
        }
        SinglyLinkedList node = this;
        if (position >= length) {
            while (node.next != null) {
                node = node.next;
            }
        } else {
            int pos = 0;
            while (pos != position - 1) {
                node = node.next;
                pos++;
            }
            newNode.next = node.next;
        }
        node.next = newNode;
        length++;
        return this;
    }

    public SinglyLinkedList remove(int value) {
        SinglyLinkedList node = this, prevNode = null;
        while (node.value != value) {
            prevNode = node;
            node = node.next;
        }
        length--;
        if (prevNode == null) {
            node.next.length = length;
            return node.next;
        }
        prevNode.next = node.next;
        return this;
    }

    public SinglyLinkedList removeAtPosition(int position) {
        if (position == 0) {
            this.next.length = this.length - 1;
            return this.next;
        }
        SinglyLinkedList node = this;
        int pos = 0;
        while (pos != position - 1) {
            node = node.next;
            pos++;
        }
        node.next = node.next.next;
        length--;
        return this;
    }

    public String toString() {
        StringBuffer text = new StringBuffer().append(this.value);
        SinglyLinkedList node = this;
        while (node.next != null) {
            node = node.next;
            text.append(" ").append(node.value);
        }
        return text.toString();
    }
}