package com.yatsynaKateryna.sb;

public class SortingAlgo_MergeSort extends SortingAlgo {
    public SortingAlgo_MergeSort(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        mergeSort(arr,0,arr.length, 0);
    }
}
