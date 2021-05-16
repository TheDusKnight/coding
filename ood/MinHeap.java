package ood;
import java.util.*;

public class MinHeap {
    // fields
    private int[] array;
    private int size;
    private final static int DEFAULT_CAP = 100;

    // methods
    public MinHeap() {
        array = new int[DEFAULT_CAP];
        size = 0;
    }

    public MinHeap(int cap) {
        // cc
        if (cap <= 0) throw new IllegalArgumentException("cap cannot be <= 0");

        array = new int[cap];
        size = 0;
    }

    public MinHeap(int[] array) { // clone vs copyOf
        // cc
        this.array = Arrays.copyOf(array, array.length * 2); // set new length
        size = this.array.length;
        heapify();
    }

    public void offer(int val) {
        if (size >= array.length) {
            // int[] newArray = new int[size * 2];
            int[] newArray = Arrays.copyOf(array, size * 2);
            array = newArray;
        }
        array[size] = val;
        percolateUp(size);
        size++;
    }

    public int poll() {
        if (size <= 0) throw new IllegalArgumentException();
        
        int tmp = array[0];
        swap(0, size-1);
        percolateDown(0);
        size--;
        return tmp;
    }

    public int update(int index, int val) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        
        int tmp = array[index];
        array[index] = val;
        if (tmp < val) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return tmp;
    }

    private void heapify() {
        // 最后一个leaf node的parent node
        int last_parent = (size - 2) / 2;
        // int left_child = size-1;
        // int right_child = size;

        // 自右向左，自下向上做percolateDown
        for (int i = last_parent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        if (index < 0 || index > array.length-1)
            throw new IllegalArgumentException();

        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(parent, index);
                index = parent;
            } else {
                // finish work
                break;
            }
        }
    }

    private void percolateDown(int index) {
        if (index < 0 || index > array.length-1)
            throw new IllegalArgumentException();
        
        while (index <= (size - 2) / 2) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int shiftIndex = left;
            if (right < size) {
                if (array[right] < array[left]) {
                    shiftIndex = right;
                }
            }

            if (array[index] > array[shiftIndex]) {
                swap(index, shiftIndex);
                index = shiftIndex;
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
