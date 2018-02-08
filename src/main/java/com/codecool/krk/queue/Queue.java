package com.codecool.krk.queue;

public class Queue<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.size = 0;
    }
}
