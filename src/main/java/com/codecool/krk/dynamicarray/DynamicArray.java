package com.codecool.krk.dynamicarray;

public class DynamicArray<T> {
    // specify how many time increase size of dynamicArray
    private final int FACTOR;

    private int size;
    private T[] dynamicArray;

    public DynamicArray() {
        this.FACTOR = 2;
        this.size = 16;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public DynamicArray(int size) {
        this.FACTOR = 2;
        this.size = size;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public DynamicArray(int FACTOR, int size) {
        this.FACTOR = FACTOR;
        this.size = size;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public int getFACTOR() {
        return FACTOR;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getDynamicArray() {
        return dynamicArray;
    }

    public void setDynamicArray(T[] dynamicArray) {
        this.dynamicArray = dynamicArray;
    }
}
