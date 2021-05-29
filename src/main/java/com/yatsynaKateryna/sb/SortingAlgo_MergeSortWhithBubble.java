package com.yatsynaKateryna.sb;

public class SortingAlgo_MergeSortWhithBubble extends SortingAlgo {
    public SortingAlgo_MergeSortWhithBubble(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        mergeSort(arr,0,arr.length, 20);
    }
}
