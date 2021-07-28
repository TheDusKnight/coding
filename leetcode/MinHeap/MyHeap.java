package leetcode.MinHeap;

import java.util.Arrays;

public class MyHeap {
    private int[] array;
    private int size;
    private static final int DEFAULT_CAP = 100;

    public MyHeap() {
        this.array = new int[DEFAULT_CAP];
        this.size = 0;
    }

    public MyHeap(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();

        this.array = new int[capacity];
        this.size = 0; // ?
    }

    public MyHeap(int[] array) {
        // cc
        this.array = Arrays.copyOf(array, array.length * 2);
        this.size = array.length;
        heapify();
    }

    public void offer(int val) {
        if (size >= array.length) {
            int[] newArray = Arrays.copyOf(array, size * 2);
            array = newArray;
        }

        array[size] = val;
        size++;
        percolateUp(size - 1);
    }

    public int poll() {
        if (size <= 0) throw new IllegalArgumentException();

        int tmp = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return tmp;
    }

    public int update(int idx, int val) {
        if (idx < 0 || idx >= size) throw new IllegalArgumentException();

        int tmp = array[idx];
        array[idx] = val;
        percolateUp(idx);
        percolateDown(idx);
        return tmp;
    }

    private void heapify() {
        // cc
        int lastParent = (size - 2) / 2;
        for (int i = lastParent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int idx) {
        // cc
        while (idx >= 0) {
            int parent = (idx - 1) / 2;
            if (array[parent] > array[idx]) {
                swap(parent, idx);
                idx = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int idx) {
        // cc
        while (idx <= (size - 2) /2) {
            int l = idx * 2 + 1;
            int r = idx * 2 + 2;
            int shiftIdx = l;
            if (r < size && array[r] < array[l]) {
                shiftIdx = r;
            }
            if (array[idx] > array[shiftIdx]) {
                swap(idx, shiftIdx);
                idx = shiftIdx;
            } else {
                break;
            }
        }
    }

    private void swap(int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}