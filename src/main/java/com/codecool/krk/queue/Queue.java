package com.codecool.krk.queue;

public class Queue<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    // Implement to keep naming similar to Collection interface implementations
    public int size() {
        return getSize();
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
