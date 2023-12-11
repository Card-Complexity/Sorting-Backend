package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public String bubbleSort() {
        Bubble bubble = new Bubble();
        String result = bubble.test();
        return result;
    }

    public String insertionSort() {
        Insertion insertion = new Insertion();
        String result = insertion.test();
        return result;
    }

    public String mergeSort() {
        Merge merge = new Merge();
        String result = merge.test();
        return result;
    }

    public String selectionSort() {
        Selection selection = new Selection();
        String result = selection.test();
        return result;
    }

    public String bubbleCards() {
        BubbleSuite bubble = new BubbleSuite();
        String result = bubble.cardPopulate();
        return result;
    }

    public String insertionCards() {
        InsertionSuite insertion = new InsertionSuite();
        String result = insertion.cardPopulate();
        return result;
    }

    public String mergeCards() {
        MergeSuite merge = new MergeSuite();
        String result = merge.cardPopulate();
        return result;
    }

    public String selectionCards() {
        SelectionSuite selection = new SelectionSuite();
        String result = selection.cardPopulate();
        return result;
    }

    public String fibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        String result = fibonacci.test();
        return result;
    }
}
