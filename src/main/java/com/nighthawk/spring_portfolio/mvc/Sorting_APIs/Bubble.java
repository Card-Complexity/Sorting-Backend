package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

public class Bubble extends Generics {
    @Override
    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                iterations++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    comparisons++;
                } else {
                    comparisons++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble bs = new Bubble();
        bs.testRandomValues();
        bs.test();
    }
}
