package com.codecool.krk.stack;

import com.codecool.krk.stack.customexception.StackOverflow;
import com.codecool.krk.stack.customexception.StackUnderflow;

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

    // Implement to keep naming similar to Collection interface implementations
    public int size() {
        return getSize();
    }

    public int getStackFreeSpace() {
        int numberOfElementsInStack = this.top + 1;
        return this.size - numberOfElementsInStack;
    }

    public void push(T data) throws StackOverflow {
        validateIsStackOverflow();
        this.top++;
        this.stack[this.top] = data;
    }

    private void validateIsStackOverflow() throws StackOverflow {
        if (this.top == this.size -1) {
            throw new StackOverflow("Stack Overflow");
        }
    }

    public T pop() throws StackUnderflow {
        validateIsStackUnderflow();

        T data = this.stack[this.top];
        this.top--;

        return data;
    }

    public T peek() {
        T data = null;

        if (this.top >= 0) {
            data = this.stack[this.top];
        }

        return data;
    }

    private void validateIsStackUnderflow() throws StackUnderflow {
        if (this.top == -1) {
            throw new StackUnderflow("Stack Underflow");
        }
    }
}
