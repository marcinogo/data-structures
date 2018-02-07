package com.codecool.krk.doublylinkedlist;

public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> last;
    private int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public DoublyNode<T> getHead() {
        return head;
    }

    public void setHead(DoublyNode<T> head) {
        this.head = head;
    }

    public DoublyNode<T> getLast() {
        return last;
    }

    public void setLast(DoublyNode<T> last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement to keep naming similar to Collection interface implementations
    public int size() {
        return getLength();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        DoublyNode<T> current = this.head;

        while (current.getNextNode() != null) {
            if (current.getData().equals(data)) {
                return true;
            }
        }

        return false;
    }
}
