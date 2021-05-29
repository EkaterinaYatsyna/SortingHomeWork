package com.prituladima.sb;

public class SortingAlgo_BitRadixSort extends SortingAlgo {
    public SortingAlgo_BitRadixSort(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        bitRadixSort(arr,30,0,arr.length, 0);
    }
}
