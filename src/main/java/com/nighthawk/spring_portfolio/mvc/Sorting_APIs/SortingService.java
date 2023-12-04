package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public int[] bubbleSort(int[] array) {
        Bubble bubble = new Bubble();
        bubble.sort(array);
        return array;
    }

    public int[] insertionSort(int[] array) {
        Insertion insertion = new Insertion();
        insertion.sort(array);
        return array;
    }

    public int[] mergeSort(int[] array) {
        Merge merge = new Merge();
        merge.sort(array);
        return array;
    }

    public int[] selectionSort(int[] array) {
        Selection selection = new Selection();
        selection.sort(array);
        return array;
    }

}
