package com.prituladima.sb;

import java.util.Arrays;

public class SortingAlgo_parallelSort extends SortingAlgo {
    public SortingAlgo_parallelSort(int len) {
        super(len);
    }

    @Override
    void sort(int[] arr) {
        Arrays.parallelSort(arr);
    }
}
