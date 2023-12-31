package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

public class Merge extends Generics {
    @Override
    public void sort(int[] arr) {
        // reset instance variables
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        mergeSort(arr, 0, arr.length - 1);
    }

    // recursive method for merge sort
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // middle point
            int mid = left + (right - left) / 2;

            // split both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // merging sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        // merging arrays

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            iterations++;
            if (leftArr[i] <= rightArr[j]) {
                // Only increment swaps if there's an actual change in the value
                if (arr[k] != leftArr[i]) {
                    swaps++;
                }
                arr[k] = leftArr[i];
                i++;
            } else {
                // Only increment swaps if there's an actual change in the value
                if (arr[k] != rightArr[j]) {
                    swaps++;
                }
                arr[k] = rightArr[j];
                j++;
            }
            k++;
            comparisons++;
        }

        while (i < n1) {
            // Only increment swaps if there's an actual change in the value
            if (arr[k] != leftArr[i]) {
                swaps++;
            }
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            // Only increment swaps if there's an actual change in the value
            if (arr[k] != rightArr[j]) {
                swaps++;
            }
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        m.testRandomValues();
        m.test();
    }
}
