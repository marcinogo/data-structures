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

    public T[] getStack() {
        return stack;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
