package com.prituladima.sb;

public class SortingAlgo_QuickSort extends SortingAlgo {
    public SortingAlgo_QuickSort(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1, 0);
    }
}
