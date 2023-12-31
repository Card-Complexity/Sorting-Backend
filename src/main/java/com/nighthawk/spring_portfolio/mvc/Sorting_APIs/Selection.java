package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

public class Selection extends Generics {
    @Override
    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                iterations++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                comparisons++;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            swaps++;
        }
    }

    public static void main(String[] args) {
        Selection ss = new Selection();
        ss.testRandomValues();
        ss.test();
    }
}
