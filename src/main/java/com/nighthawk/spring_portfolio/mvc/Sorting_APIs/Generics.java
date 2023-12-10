package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import java.util.Arrays;
import java.util.Random;
import com.google.gson.JsonObject;

public class Generics {
    // instance variables to keep track of iterations, comparisons, and swaps
    protected int iterations;
    protected int comparisons;
    protected int swaps;

    public void sort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;
    }

    public String test() {
        int arrayAmount = 0;
        int arraySize = 5000;
        long startTime = System.nanoTime();
        for (int i = 0; i <= 12; i++) {
            int[] arr = new int[arraySize];
            Random rand = new Random();

            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt(1000);
            }
            sort(arr);
            arrayAmount = i++;
        }
        long endTime = System.nanoTime();
        System.out.println("Total arrays: " + arrayAmount);
        System.out.println("Total array size per array: " + arraySize);
        System.out.println("Total iterations: " + iterations);
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);
        System.out.println("Total time: " + (endTime - startTime) / 1000000 + " ms");

        JsonObject analytics = new JsonObject();
        analytics.addProperty("TotalArrays", arrayAmount);
        analytics.addProperty("TotalArraySize", arraySize);
        analytics.addProperty("TotalIterations", iterations);
        analytics.addProperty("TotalComparisons", comparisons);
        analytics.addProperty("TotalSwaps", swaps);
        analytics.addProperty("TotalTime", (endTime - startTime) / 1000000 + " ms");

        String analyticsString = analytics.toString();
        System.out.println("Analytics: " + analyticsString);
        return analyticsString;
    }

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
}