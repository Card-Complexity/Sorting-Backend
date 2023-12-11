package com.nighthawk.spring_portfolio.mvc.Sorting_APIs;

import java.util.Arrays;
import java.util.Random;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CardSuite extends Generics {
    public String cardPopulate() {
        JsonObject analytics = new JsonObject();
        int[] arr = new int[13];
        Random rand = new Random();
        boolean[] used = new boolean[14]; // to keep track of used values
        // Generate random values between 1-13 and arrange them randomly
        for (int i = 0; i < arr.length; i++) {
            int value = rand.nextInt(13) + 1;
            while (used[value]) {
                value = rand.nextInt(13) + 1;
            }
            arr[i] = value;
            used[value] = true;
        }
        analytics.addProperty("BeforeSorting", Arrays.toString(arr));
        System.out.println("Before sorting: " + Arrays.toString(arr));

        // Perform sorting and measure time
        long startTime = System.nanoTime();
        JsonArray movements = cardSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // in milliseconds

        System.out.println("After sorting: " + Arrays.toString(arr));
        System.out.println("Iterations: " + iterations);
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Time taken: " + duration + " milliseconds");

        // Create analytics JSON object
        analytics.addProperty("AfterSorting", Arrays.toString(arr));
        analytics.addProperty("Iterations", iterations);
        analytics.addProperty("Swaps", swaps);
        analytics.addProperty("Comparisons", comparisons);
        analytics.addProperty("TimeTaken", duration);

        movements.add(analytics);

        // Send the analytics JSON object via HTTP request or do further processing
        System.out.println("Data: " + movements.toString());
        return movements.toString();
    }

    public JsonArray cardSort(int[] arr) {
        JsonArray movements = new JsonArray();
        return movements;
    }
}

class BubbleSuite extends CardSuite {
    @Override
    public JsonArray cardSort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        JsonArray movements = new JsonArray();

        for (int i = 0; i < n - 1; i++) {
            iterations++;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Add movement to JSON array
                    JsonObject movement = new JsonObject();
                    movement.addProperty("B", arr[j]);
                    movement.addProperty("Original", j);
                    movement.addProperty("Final", j + 1);
                    movements.add(movement);
                }
                iterations++;
            }
        }

        // Convert JSON array to string
        String jsonMovements = movements.toString();

        // Send the JSON string via HTTP request or do further processing
        System.out.println(jsonMovements);

        return movements;
    }
}

class SelectionSuite extends CardSuite {
    @Override
    public JsonArray cardSort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        JsonArray movements = new JsonArray();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            iterations++;
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
                iterations++;
            }

            // Swap the found minimum element with the first
            // element
            swaps++;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

            // Add movement to JSON array
            JsonObject movement = new JsonObject();
            movement.addProperty("S", arr[i]);
            movement.addProperty("Original", min_idx);
            movement.addProperty("Final", i);
            movements.add(movement);
        }

        // Convert JSON array to string
        String jsonMovements = movements.toString();

        // Send the JSON string via HTTP request or do further processing
        System.out.println(jsonMovements);
        return movements;
    }
}

class InsertionSuite extends CardSuite {
    @Override
    public JsonArray cardSort(int[] arr) {
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        int n = arr.length;
        JsonArray movements = new JsonArray();
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            iterations++;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                swaps++;
                arr[j + 1] = arr[j];

                // Record movement before updating the array
                JsonObject movement = new JsonObject();
                movement.addProperty("I", arr[j]);
                movement.addProperty("Original", j);
                movement.addProperty("Final", j + 1);
                movements.add(movement);

                j = j - 1;
                iterations++;
            }
            swaps++;
            arr[j + 1] = key;

            // Add movement to JSON array for the key
            JsonObject movement = new JsonObject();
            movement.addProperty("I", key);
            movement.addProperty("Original", i);
            movement.addProperty("Final", j + 1);
            movements.add(movement);
        }

        // Convert JSON array to string
        String jsonMovements = movements.toString();

        // Send the JSON string via HTTP request or do further processing
        System.out.println(jsonMovements);
        return movements;
    }
}

class MergeSuite extends CardSuite {

    @Override
    public JsonArray cardSort(int[] arr) {
        // reset instance variables
        iterations = 0;
        comparisons = 0;
        swaps = 0;

        JsonArray movements = new JsonArray();
        mergeSort(arr, 0, arr.length - 1, movements);

        // Convert JSON array to string
        String jsonMovements = movements.toString();

        // Send the JSON string via HTTP request or do further processing
        System.out.println(jsonMovements);
        return movements;
    }

    // recursive method for merge cardSort
    private void mergeSort(int[] arr, int left, int right, JsonArray movements) {
        if (left < right) {
            // middle point
            int mid = left + (right - left) / 2;

            // split both halves
            mergeSort(arr, left, mid, movements);
            mergeSort(arr, mid + 1, right, movements);

            // merging sorted halves
            merge(arr, left, mid, right, movements);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, JsonArray movements) {
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

            // Add movement to JSON array
            JsonObject movement = new JsonObject();
            movement.addProperty("M", arr[k - 1]);
            movement.addProperty("Original", k - 1);
            movement.addProperty("Final", k);
            movements.add(movement);
        }

        while (i < n1) {
            // Only increment swaps if there's an actual change in the value
            if (arr[k] != leftArr[i]) {
                swaps++;
            }
            arr[k] = leftArr[i];
            i++;
            k++;

            // Add movement to JSON array
            JsonObject movement = new JsonObject();
            movement.addProperty("M", arr[k - 1]);
            movement.addProperty("Original", k - 1);
            movement.addProperty("Final", k);
            movements.add(movement);
        }

        while (j < n2) {
            // Only increment swaps if there's an actual change in the value
            if (arr[k] != rightArr[j]) {
                swaps++;
            }
            arr[k] = rightArr[j];
            j++;
            k++;

            // Add movement to JSON array
            JsonObject movement = new JsonObject();
            movement.addProperty("M", arr[k - 1]);
            movement.addProperty("Original", mid + 1 + j - 1);
            movement.addProperty("Final", k - 1);
            movements.add(movement);
        }
    }

    public static void main(String[] args) {
        // BubbleSuite bs = new BubbleSuite();
        // bs.cardPopulate();
        // SelectionSuite ss = new SelectionSuite();
        // ss.cardPopulate();
        // InsertionSuite is = new InsertionSuite();
        // is.cardPopulate();
        MergeSuite ms = new MergeSuite();
        ms.cardPopulate();
    }
}
