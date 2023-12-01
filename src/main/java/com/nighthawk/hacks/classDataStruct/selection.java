package com.nighthawk.hacks.classDataStruct;

import java.util.Arrays;
import java.util.Random;

public class selectionSort {
    // instance variables to keep track of iterations, comparisons, and swaps
    private int iterations;
    private int comparisons;
    private int swaps;

    // method to perform selection sort on an array
    public void sort(int[] arr) {
        // reset instance variables
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

    // method to test the performance of selection sort on random arrays
    public void test() {
        // start timer
        long startTime = System.nanoTime();
        // perform selection sort on 12 random arrays
        for (int i = 0; i < 12; i++) {
            int[] arr = new int[5000];
            Random rand = new Random();

            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt(1000);
            }

            sort(arr);
        }
        // stop timer
        long endTime = System.nanoTime();

        // print out performance metrics
        System.out.println("Total iterations: " + iterations);
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);
        System.out.println("Total time: " + (endTime - startTime) / 1000000 + " ms");
    }

    // method to test selection sort on a small array of random values
    public void testRandomValues() {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }

        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    // main method to run the program
    public static void main(String[] args) {
        selectionSort ss = new selectionSort();
        ss.testRandomValues();
        ss.test();
    }
}

selectionSort.main(null);
