package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public int[] bubbleSort(int[] array) {
        Bubble.sort(array); // Bubble.sort(array
        return array;

    }

    public int[] insertionSort(int[] array) {
        return Insertion.insertionSort(array);
    }

    public int[] mergeSort(int[] array) {
        return Merge.mergeSort(array);
    }

    public int[] selectionSort(int[] array) {
        return Selection.selectionSort(array);
    }

}
