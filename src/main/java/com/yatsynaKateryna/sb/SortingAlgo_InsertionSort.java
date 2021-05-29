package com.yatsynaKateryna.sb;

public class SortingAlgo_InsertionSort extends SortingAlgo{
    public SortingAlgo_InsertionSort(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        insertionSort(arr, 0, arr.length);
    }
}
