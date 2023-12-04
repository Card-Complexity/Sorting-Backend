package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import org.hibernate.sql.Insert;

public class Insertion extends Generics {
    @Override
    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Element changes position
                j--;
                iterations++;
                comparisons++;
                swaps++;
            }
            arr[j + 1] = key; // Element changes position
            swaps++;
        }
    }

    public static void main(String[] args) {
        Insertion is = new Insertion();
        is.testRandomValues();
        is.test();
    }
}
