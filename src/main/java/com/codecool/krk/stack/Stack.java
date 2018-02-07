package com.codecool.krk.stack;

public class Stack<T> {
    private T[] stack;
    private int size;
    private int top;

    public Stack(int size) {
        this.size = size;
        
        this.top = -1;
        this.stack = (T[]) new Object[this.size];
    }
}
