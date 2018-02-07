package com.codecool.krk.singlylinkedlist;

public class SinglyLinkedList<T> {
    private SinglyNode<T> head;
    private SinglyNode<T> last;
    private int length;

    public SinglyLinkedList() {
        this.length = 0;
    }

    public SinglyNode<T> getHead() {
        return head;
    }

    public void setHead(SinglyNode<T> head) {
        this.head = head;
    }

    public SinglyNode<T> getLast() {
        return last;
    }

    public void setLast(SinglyNode<T> last) {
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
}
