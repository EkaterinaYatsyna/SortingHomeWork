package com.prituladima.sb;

public class SortingAlgo_BitRadixSortWhithBubble extends SortingAlgo {
    public SortingAlgo_BitRadixSortWhithBubble(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        bitRadixSort(arr,30,0,arr.length, 20);
    }
}
