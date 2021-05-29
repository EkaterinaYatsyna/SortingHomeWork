package com.prituladima.sb;

public class SortingAlgo_QuickSortWhithBubble extends SortingAlgo {
    public SortingAlgo_QuickSortWhithBubble(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1, 20);
    }
}
