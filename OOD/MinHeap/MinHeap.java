package OOD.MinHeap;

import java.util.Arrays;

import OOD.Inherit.MyInherit;

// 实现一个带update功能的minHeap
public class MinHeap {
    private int[] array;
    private int size;
    private final static int DEFAULT_CAP = 100;

    public MinHeap() {
        this.array = new int[DEFAULT_CAP];
        this.size = 0;
    }

    public MinHeap(int cap) {
        if (cap <= 0) // 等于0是否可以
            throw new IllegalArgumentException("cap cannot be <= 0");

        this.array = new int[cap];
        this.size = 0;
    }

    public MinHeap(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("array invalid");
        // 在这里copyOf比clone好因为可以set new length
        this.array = Arrays.copyOf(array, array.length * 2); // set new length
        this.size = array.length; // size必须是input array的长度
        heapify();
    }

    public void offer(int val) {
        if (size >= array.length) {
            int[] newArray = Arrays.copyOf(array, size * 2);
            array = newArray;
        }
        array[size] = val;
        size++;
        percolateUp(size - 1); // 这里值更新后size-1，也就是offer val的位置
    }

    public int poll() {
        if (size <= 0)
            throw new IllegalArgumentException();

        int tmp = array[0];
        swap(0, size - 1);
        // array[0] = array[size - 1];
        // 注意size--最好放到p down前面防止idx size和上面的node swap，但不可能发生因为idx size本身就比上一层所有元素大
        size--;
        percolateDown(0);
        return tmp;
    }

    public int update(int index, int val) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();

        int tmp = array[index];
        array[index] = val;
        if (tmp < val) { // check非必要，直接p down，p up因为index原因只有一个method能percolate
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return tmp;
    }

    private void heapify() {
        // 最后一个leaf node的parent node
        int lastParent = (size - 2) / 2;
        // int left_child = size-1;
        // int right_child = size;

        // 自右向左，自下向上做percolateDown
        for (int i = lastParent; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        if (index < 0 || index > array.length - 1)
            throw new IllegalArgumentException();

        while (index > 0) { // 不能等于0，否则没有parent
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        if (index < 0 || index > array.length - 1)
            throw new IllegalArgumentException();

        while (index <= (size - 2) / 2) { // 说明index可以p down
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int shiftIndex = left;
            // right index存在并且右边小于左边
            if (right < size && array[right] < array[left])
                shiftIndex = right;

            if (array[index] > array[shiftIndex]) {
                swap(index, shiftIndex); // 把小的数换上来
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

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[] { 2, 3, 1, 4 });
        System.out.println(Arrays.toString(minHeap.array));
    }
}
