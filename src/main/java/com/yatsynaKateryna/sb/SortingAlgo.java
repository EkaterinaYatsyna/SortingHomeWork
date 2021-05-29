package com.yatsynaKateryna.sb;

import java.util.Random;

public abstract class SortingAlgo {

    protected static final int SMALL_SIZE = 27;

    private final int len;

    public SortingAlgo(int len) {
        this.len = len;
    }

    public String name() {
        return this.getClass().getSimpleName();
    }

    public long sortAndMeasureTime() {
        int[] array = generate(len);
        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        validateSorted(array);
        array = null;
        return end - start;
    }

    private void validateSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new RuntimeException("Wrong algo in " + name());
            }
        }
    }


    private int[] generate(int len) {
        int[] ans = new int[len];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < ans.length; i++) {
            ans[i] = random.nextInt() & 0x7fffffff;
        }
        return ans;
    }

    abstract void sort(int[] arr);

    protected void slowSort(int[] arr, int from, int upTo) {
//        bubbleSort(arr, from, upTo);
        insertionSort(arr, from, upTo);
    }


    protected void bubbleSort(int[] arr, int from, int upTo) {
        for (int i = from; i < upTo; i++) {
            int minVal = arr[i];
            int minInd = i;
            for (int j = i + 1; j < upTo; j++) {
                if (minVal > arr[j]) {
                    minVal = arr[j];
                    minInd = j;
                }
            }
            swap(arr, minInd, i);
        }
    }

    protected void bubbleSort(int[] arr) {
        bubbleSort(arr, 0, arr.length);
    }

    protected void insertionSort(int[] arr, int from, int upTo) {
        for (int i = from + 1; i < upTo; i++) {
            //[from..i) is sorted
            //Lets find the index where to insert
            //lower_bound
            int low = from - 1;//wrong value from left
            int high = i;//maybe correct value right
            final int value = arr[i];
            while (high - low > 1) {
                int mid = (low + high) >>> 1;
                if (value <= arr[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            int val = arr[i];
//            for(int j = i ; j > high ; j--){
//                arr[j] = arr[j - 1];
//            }
            if (i - high >= 0) System.arraycopy(arr, high, arr, high + 1, i - high);
            arr[high] = val;

        }
    }


    protected static void swap(int[] arr, int first, int second) {
//        int temp = arr[first];
//        arr[first] = arr[second];
//        arr[second] = temp;

        if (arr[first] != arr[second]) {
            arr[first] = arr[first] ^ arr[second];
            arr[second] = arr[first] ^ arr[second];
            arr[first] = arr[first] ^ arr[second];
        }
    }

    protected void bitRadixSort(int[] arr, int bits, int from, int upTo, int opt) {

        if (upTo - from > opt) {
            if (bits > -1) {
                int partition = partitionBit(arr, bits, from, upTo);
                if (partition > 0) {
                    bitRadixSort(arr, bits - 1, from, from + partition, opt);
                }
                if (from + partition < upTo) {
                    bitRadixSort(arr, bits - 1, from + partition, upTo, opt);
                }
            }
        } else {
            bubbleSort(arr, from, upTo);
        }
    }

    protected static int partitionBit(int[] arr, int bits, int from, int upTo) {

        int j = from;
        int quantity = 0;

        for (int i = from; i < upTo; i++) {
            if ((arr[i] & 1 << bits) == 0) {
                swap(arr, i, j);
                j++;
                quantity++;
            }
        }
        return quantity;
    }

    protected void quickSort(int[] arr, int from, int upTo, int opt) {
        if (upTo - from > opt) {
            Random random = new Random();
            int randomInd = from + random.nextInt(upTo - from);
            swap(arr, upTo, randomInd);


            int last = arr[upTo];
            int j = from;
            for (int i = from; i < upTo; i++) {
                if (arr[i] < last) {
                    swap(arr, j, i);
                    j++;
                }
            }
            swap(arr, j, upTo);

            if (j - 1 > from) {
                quickSort(arr, from, j - 1, opt);
            }
            if (j + 1 < upTo) {
                quickSort(arr, j + 1, upTo, opt);
            }
        } else {
            bubbleSort(arr, from, upTo+1);
        }

    }


    protected  void mergeSort(int[] arr, int from, int upTo, int opt) {
        if (upTo - from > 1) {
            if (upTo - from > opt) {
                int mid = from + (upTo - from) / 2;
                mergeSort(arr, from, mid, opt);
                mergeSort(arr, mid, upTo, opt);
                merge(arr, from, mid, mid, upTo, from, upTo);
            } else {
                bubbleSort(arr, from, upTo);
            }
        }
    }

    //
    private static void merge(int[] arr,
                              int from1, int upto1,
                              int from2, int upto2,
                              int from3, int upTo3) {

        int[] res = new int[upTo3 - from3];
        int ind1 = from1;
        int ind2 = from2;
        int indRes = 0;
        while (ind1 < upto1 && ind2 < upto2) {
            if (arr[ind1] < arr[ind2]) {
                res[indRes++] = arr[ind1++];
            } else {
                res[indRes++] = arr[ind2++];
            }
        }

        while (ind1 < upto1) {
            res[indRes++] = arr[ind1++];
        }
        while (ind2 < upto2) {
            res[indRes++] = arr[ind2++];
        }

        if (upTo3 - from3 >= 0) {
            System.arraycopy(res, 0, arr, from3, upTo3 - from3);
        }

    }
}
